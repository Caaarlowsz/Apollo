package me.staud.apollo.scoreboard;

public class NegoxOptions
{
    private boolean hook;
    private boolean scoreDirectionDown;
    private boolean viperMode; // only able to be on without scoredirectiondown & curamode
    private boolean curaMode; // only able to be on without scoredirection & vipermode

    static NegoxOptions defaultOptions() {
        return new NegoxOptions().hook(true).scoreDirectionDown(true).viperMode(false).curaMode(false);
    }

    public boolean hook() {
        return this.hook;
    }

    public boolean scoreDirectionDown() {
        return this.scoreDirectionDown;
    }

    public boolean viperMode() {
        return this.viperMode;
    }

    public boolean curaMode() {
        return this.curaMode;
    }

    public NegoxOptions hook(final boolean hook) {
        this.hook = hook;
        return this;
    }

    public NegoxOptions scoreDirectionDown(final boolean scoreDirectionDown) {
        this.scoreDirectionDown = scoreDirectionDown;
        return this;
    }


    public NegoxOptions viperMode(final boolean viperMode) {
        this.viperMode = viperMode;
        return this;
    }

    public NegoxOptions curaMode(final boolean curaMode) {
        this.curaMode = curaMode;
        return this;
    }

}
