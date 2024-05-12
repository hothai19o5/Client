package app;
// Phần này đang bị lỗi nên không dùng nữa
public enum MessageType {
    TEXT(1), EMOJI(2), FILE(3);
    
    private int value;
    
    private MessageType(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public static MessageType toMessageType(int value){
        if(value == 1){
            return TEXT;
        }else if(value == 2){
            return EMOJI;
        }else {
            return FILE;
        }
    }
}
