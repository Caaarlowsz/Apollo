package me.staud.apollo.scoreboard.provider;

import me.staud.apollo.scoreboard.Negox;
import me.staud.apollo.scoreboard.NegoxOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board
{
    private static Set<Board> boards;
    private Scoreboard scoreboard;
    private Player player;
    private Objective objective;
    private Set<String> keys;
    private List<BoardEntry> entries;
    private final Negox negox;
    private final NegoxOptions options;

    static {
        Board.boards = new HashSet<Board>();
    }

    public Board(final Player player, final Negox negox, final NegoxOptions options) {
        this.player = player;
        this.negox = negox;
        this.options = options;
        this.keys = new HashSet<String>();
        this.entries = new ArrayList<BoardEntry>();
        this.setup();
    }

    private void setup() {
        if (this.options.hook() && !this.player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())) {
            this.scoreboard = this.player.getScoreboard();
        }
        else {
            this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        }
        (this.objective = this.scoreboard.registerNewObjective("negeox", "dummy")).setDisplaySlot(DisplaySlot.SIDEBAR);
        if (this.negox.getAdapter() != null) {
            this.objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.negox.getAdapter().getTitle(this.player)));
        }
        else {
            this.objective.setDisplayName("buffered");
        }
        Board.boards.add(this);
    }

    public String getNewKey(final BoardEntry entry) {
        ChatColor[] values;
        for (int length = (values = ChatColor.values()).length, i = 0; i < length; ++i) {
            final ChatColor color = values[i];
            String colorText = new StringBuilder().append(color).append(ChatColor.WHITE).toString();
            if (entry.getText().length() > 16) {
                final String sub = entry.getText().substring(0, 16);
                colorText = String.valueOf(colorText) + ChatColor.getLastColors(sub);
            }
            if (!this.keys.contains(colorText)) {
                this.keys.add(colorText);
                return colorText;
            }
        }
        throw new IndexOutOfBoundsException("No more keys available!");
    }

    public List<String> getBoardEntriesFormatted() {
        final List<String> toReturn = new ArrayList<String>();
        for (final BoardEntry entry : new ArrayList<BoardEntry>(this.entries)) {
            toReturn.add(entry.getText());
        }
        return toReturn;
    }

    public BoardEntry getByPosition(final int position) {
        int i = 0;
        for (final BoardEntry board : this.entries) {
            if (i == position) {
                return board;
            }
            ++i;
        }
        return null;
    }


    public static Board getByPlayer(final Player player) {
        for (final Board board : Board.boards) {
            if (board.getPlayer().getName().equals(player.getName())) {
                return board;
            }
        }
        return null;
    }

    public static Set<Board> getBoards() {
        return Board.boards;
    }

    public Scoreboard getScoreboard() {
        return this.scoreboard;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Objective getObjective() {
        return this.objective;
    }

    public Set<String> getKeys() {
        return this.keys;
    }

    public List<BoardEntry> getEntries() {
        return this.entries;
    }
}
