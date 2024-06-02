package model;

import event.EventFileReceiver;
import io.socket.client.Ack;
import io.socket.client.Socket;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.json.JSONException;
import org.json.JSONObject;
import service.Service;

public class Model_File_Receiver {
    private int fileID;
    private File file;
    private long fileSize;
    private String fileExtension;
    private Socket socket;
    private RandomAccessFile accessFile;
    private EventFileReceiver event;
    private final String PATH_FILE = "client_data/";

    public Model_File_Receiver() {
    }

    public Model_File_Receiver(int fileID, Socket socket, EventFileReceiver event) {
        this.fileID = fileID;
        this.socket = socket;
        this.event = event;
    }
    
    public void initReceive() {
        socket.emit("get_file", fileID, new Ack() {
            @Override
            public void call(Object... os) {
                if(os.length > 0){
                    try {
                        System.out.println("Client Model_File_Receiver initReceive");
                        fileExtension = os[0].toString();
                        fileSize = (int) os[1];
                        file = new File(PATH_FILE + fileID + fileExtension);
                        accessFile = new RandomAccessFile(file, "rw");
                        event.onStartReceiving();
                        startSaveFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    
    public void startSaveFile() throws IOException {
        Model_Request_File data = new Model_Request_File(fileID, accessFile.length());
        socket.emit("request_file", data.toJsonObject(), new Ack() {
            @Override
            public void call(Object... os) {
                try {
                    System.out.println("Client Model_File_Receiver startSaveFile");
                    if(os.length > 0){
                        byte[] data = (byte[]) os[0];  // Lấy mảng byte gửi tới
                        writeFile(data);   // Ghi thêm dữ liệu vào mảng byte nhận được 
                        event.onReceiving(getPercentage());
                        startSaveFile();
                    }else{
                        close();
                        event.onFinish(new File(PATH_FILE + fileID + fileExtension));
                        // Truyền xong rồi thì xóa khỏi Map
                        Service.getInstance().fileReceiveFinish(Model_File_Receiver.this);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // Ghi thêm dữ liệu vào mảng byte nhận được 
    public synchronized long writeFile(byte[] data) throws IOException {
        accessFile.seek(accessFile.length());
        accessFile.write(data);
        return accessFile.length();
    }
    // Tính phần trăm hoàn thành
    public double getPercentage() throws IOException {
        double percentage;
        long filePointer = accessFile.getFilePointer();
        percentage = filePointer * 100 / fileSize;
        return percentage;
    }
    
    public void close() throws IOException {
        accessFile.close();
    }

    public RandomAccessFile getAccessFile() {
        return accessFile;
    }

    public void setAccessFile(RandomAccessFile accessFile) {
        this.accessFile = accessFile;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
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

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public EventFileReceiver getEvent() {
        return event;
    }

    public void setEvent(EventFileReceiver event) {
        this.event = event;
    }
    
}
