package geocoder.kw.tex.myapplication.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by User on 16-Nov-17.
 */
@Entity(indexes = {
        @Index(value = "tglJadian DESC")
})
public class Mantan {
    @Id(autoincrement = true)
    private Long id;

    @Property
    private String nama;
    private String tglJadian;
    private String tglPutus;

    @Generated(hash = 1837939752)
    public Mantan(Long id, String nama, String tglJadian, String tglPutus) {
        this.id = id;
        this.nama = nama;
        this.tglJadian = tglJadian;
        this.tglPutus = tglPutus;
    }

    @Generated(hash = 1654288686)
    public Mantan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglJadian() {
        return tglJadian;
    }

    public void setTglJadian(String tglJadian) {
        this.tglJadian = tglJadian;
    }

    public String getTglPutus() {
        return tglPutus;
    }

    public void setTglPutus(String tglPutus) {
        this.tglPutus = tglPutus;
    }
}
