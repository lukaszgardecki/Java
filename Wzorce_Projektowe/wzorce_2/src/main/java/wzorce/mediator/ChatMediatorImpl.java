package wzorce.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        users.stream()
                .filter(u -> u != user) // wiadomość otrzumują wszyscy użytkownicy poza tym, który wysłał
                .forEach(u -> u.receive(msg));
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
