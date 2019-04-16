package rocks.zipcode.io.objectorientation;

public class Television {
    private boolean isTurnedOn;
    private TVChannel tvChannel;

    public Television() {
        isTurnedOn = false;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void setChannel(Integer channel) {
        if (!isTurnedOn)
            throw new IllegalStateException("Television is not turned on");

        tvChannel = TVChannel.getByOrdinal(channel);
    }

    public TVChannel getChannel() {
        return tvChannel;
    }
}
