package model;

import event.EventFileSender;
import io.socket.client.Ack;
import io.socket.client.Socket;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import service.Service;

public class Model_File_Sender {

    private Model_Send_Message message;
    private int fileID;
    private String fileExtension;   // Phần mở rộng của file
    private File file;
    private long fileSize;          // fileSize tính bằng byte
    //RandomAccessFile được sử dụng để đọc và ghi dữ liệu từ và đến một tập tin theo cách không tuần tự
    private RandomAccessFile accessFile;
    private Socket socket;
    private EventFileSender event;  // Phần này để hiển thị quá trình gửi ảnh 

    public Model_File_Sender() {
    }

    public Model_File_Sender(Model_Send_Message message, File file, Socket socket) throws IOException {
        this.message = message;
        this.file = file;
        // RandomAccessFile đặt ở chế độ mở file chỉ đọc
        this.accessFile = new RandomAccessFile(file, "r");
        this.fileExtension = getExtension(file.getAbsolutePath().toLowerCase());
        this.fileSize = accessFile.length();
        this.socket = socket;
    }

    // Đọc dữ liệu từ file 
    public synchronized byte[] readFile() throws IOException {
        // Dùng synchronized để đổng bộ, 1 thời điểm chỉ cho 1 luồng đọc dữ liệu từ file
        long filepointer = accessFile.getFilePointer(); // Lấy con trỏ vị trí tiếp theo sẽ đọc
        if (filepointer != fileSize) { // Nếu con trỏ file không trỏ tới cuối file
            int max = 2000; // Số byte max mỗi lần truyền
            long length = filepointer + max >= fileSize ? fileSize - filepointer : max;
            byte[] data = new byte[(int) length];
            accessFile.read(data);  // Đọc dữ liệu file vào mảng data
            return data;
        } else {
            return null;
        }
    }

    // Gửi File 
    public void initSend() throws IOException {
        // Gửi một sự kiện "send_to_user" kèm theo dữ liệu message dưới dạng JSON object
        socket.emit("send_to_user", message.toJsonObject(), new Ack() {
            @Override
            public void call(Object... os) {
                // Kiểm tra xem có phản hồi trả về không
                if (os.length > 0) {
                    // Lấy fileID từ phản hồi đầu tiên
                    int fileID = (int) os[0];
                    try {
                        startSend(fileID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void startSend(int fileID) throws IOException {
        this.fileID = fileID;
        if(event != null){
            event.onStartSending();
        }
        sendingFile();
    }

    public void sendingFile() throws IOException {
        Model_Package_Sender data = new Model_Package_Sender();
        data.setFileID(fileID);
        byte[] bytes = readFile();  // Đọc dữ liệu cần truyền vào mảng bytes
        if (bytes != null) {    // Nếu có dữ liệu
            data.setData(bytes);
            data.setFinish(false);
        } else {
            data.setFinish(true);
            accessFile.close();     // Đóng truy cập vào file
        }
        // Gửi dữ liệu ( đã được chuyển sang JSON )
        socket.emit("send_file", data.toJSONObject(), new Ack() {
            //callback xử lý khi có phản hồi bên nhận
            @Override
            public void call(Object... os) {
                boolean act = (boolean) os[0];
                if (act) {
                    try {
                        if (!data.isFinish()) { // Gửi tiếp
                            if (event != null) {
                                event.onSending(getPercentage());   // Tiếp tục hiển thị quá trình gửi
                            }
                            sendingFile();
                        } else {    // Thông báo cho service đã gửi xong
                            //  File send finish
                            Service.getInstance().fileSendFinish(Model_File_Sender.this);
                            if (event != null) {
                                event.onFinish();   // Gửi xong, ẩn quá trình gửi
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Phần trăm file đã gửi 
    public double getPercentage() throws IOException {
        double percentage;
        long filePointer = accessFile.getFilePointer();
        percentage = filePointer * 100 / fileSize;
        return percentage;
    }

    // Lấy phần mở rộng của file
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

    public Model_Send_Message getModel_Send_Message() {
        return message;
    }

    public void setModel_Send_Message(Model_Send_Message message) {
        this.message = message;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public RandomAccessFile getAccessFile() {
        return accessFile;
    }

    public void setAccessFile(RandomAccessFile accessFile) {
        this.accessFile = accessFile;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void addEvent(EventFileSender event){
        this.event = event;
    }

}
