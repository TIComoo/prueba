package ticomo.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Orden_Platos")
public class DatabaseSequencePlato {

    @Id
    private String id;

    private long seq;

    public DatabaseSequencePlato() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}