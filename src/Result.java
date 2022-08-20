import java.io.Serializable;


public class Result implements Serializable, Comparable<Result> {
    public static final long serialVersionUID = -938761094876384658L;
    public String url;
    public int score;
    public int urlID;

    public Result (String url, int urlID) {
        this.url = url;
        this.urlID = urlID;
        this.score = 1;
    }

    public void updateScore (int score) {
        this.score += score;
    }

    public void incrementScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public String getURL() {
        return this.url;
    }

    public int getURLID() {
        return this.urlID;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Result) {
            if (this.url.equals(((Result) obj).url)) {
                return true;
            }
        }

        return false;
    }

    public int compareTo (Result candidate) {
        if (this.score < candidate.score) {
            return 1;
        } else if (this.score == candidate.score) {
            return 0;
        } else {
            return -1;
        }
    }
}
