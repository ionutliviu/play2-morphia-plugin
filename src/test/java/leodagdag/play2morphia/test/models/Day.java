package leodagdag.play2morphia.test.models;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.PostLoad;
import com.github.jmkgreen.morphia.annotations.PrePersist;
import com.github.jmkgreen.morphia.annotations.Transient;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * User: leo
 * Date: 06/10/12
 * Time: 15:34
 */
@Embedded
public class Day {

    @Transient
    public DateTime date;

    private Date _date;

    @Embedded
    public HalfDay morning;

    @Embedded
    public HalfDay afternoon;

    @PrePersist
    void prePersist() {
        _date = date.toDate();
    }

    @PostLoad
    void postLoad() {
        date = new DateTime(_date.getTime());
    }


}
