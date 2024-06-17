export class Message {
    content: string;
    sender: string;
    type: string;
    time: string;

    static createChatMsg(content: string, username: string) {
        const message = new Message();
        message.content = content;
        message.sender = username;
        message.type = "CHAT";
        message.time = this.getCurrentTime();
        return message;
    }

    private static getCurrentTime() {
        const today = new Date();
        return `${today.getHours()}:${today.getMinutes()}`;
    }
}