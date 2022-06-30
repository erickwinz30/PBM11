package id.undika.pertemuan10splash.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class pojo_movies implements Parcelable {
    //parcelable : mengirimkan data dalam jumlah besar dengan satu kali kirim

    //deklarasi variabel dari data movie
    private String title, release_date, desc, review;
    private int poster;

    //constractor (alt+insert)
    public pojo_movies() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public pojo_movies(Parcel parcel) {
        this.title = parcel.readString();
        this.release_date = parcel.readString();
        this.desc = parcel.readString();
        this.review = parcel.readString();
        this.poster = parcel.readInt();
    }

    public static final Creator<pojo_movies> CREATOR = new Creator<pojo_movies>() {
        @Override
        public pojo_movies createFromParcel(Parcel in) {

            return new pojo_movies(in);
        }

        @Override
        public pojo_movies[] newArray(int size) {
            return new pojo_movies[size];
        }
    };

    @Override
    public int describeContents() {

        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(release_date);
        parcel.writeString(desc);
        parcel.writeString(review);
        parcel.writeInt(poster);
    }
}
