package ru.ileet.granit;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Patients implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("date1")
    @Expose
    private long date1;
    @SerializedName("date2")
    @Expose
    private long date2;
    @SerializedName("date3")
    @Expose
    private long date3;
    @SerializedName("date4")
    @Expose
    private long date4;
    @SerializedName("sms")
    @Expose
    private int sms;
    @SerializedName("diagnoz")
    @Expose
    private String diagnoz;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("prepay")
    @Expose
    private int prepay;
    @SerializedName("user")
    @Expose
    private int user;
    @SerializedName("photo")
    @Expose
    private String photo;

    public Patients(Parcel in){
        fullname = in.readString();
        date1 = in.readLong();
        diagnoz = in.readString();
        phone = in.readString();
        price = in.readInt();
        photo = in.readString();
    }

    public Patients(){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullname);
        dest.writeLong(date1);
        dest.writeString(diagnoz);
        dest.writeString(phone);
        dest.writeInt(price);
        dest.writeString(photo);
    }

    public static final Parcelable.Creator<Patients> CREATOR = new Parcelable.Creator<Patients>(){
        @Override
        public Patients createFromParcel(Parcel source) {
            return new Patients(source);
        }

        @Override
        public Patients[] newArray(int size) {
            return new Patients[size];
        }
    };

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     *
     * @param fullname
     * The fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     *
     * @return
     * The date1
     */
    public long getDate1() {
        return date1;
    }

    /**
     *
     * @return
     * The date2
     */
    public long getDate2() {
        return date2;
    }

    /**
     *
     * @return
     * The date3
     */
    public long getDate3() {
        return date3;
    }
    /**
     *
     * @return
     * The date4
     */
    public long getDate4() {
        return date4;
    }

    /**
     *
     * @return
     * The sms
     */
    public int getSms() {
        return sms;
    }

    /**
     *
     * @param sms
     * The sms
     */
    public void setSms(int sms) {
        this.sms = sms;
    }

    /**
     *
     * @return
     * The diagnoz
     */
    public String getDiagnoz() {
        return diagnoz;
    }

    /**
     *
     * @param diagnoz
     * The diagnoz
     */
    public void setDiagnoz(String diagnoz) {
        this.diagnoz = diagnoz;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The price
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The prepay
     */
    public int getPrepay() {
        return prepay;
    }

    /**
     *
     * @param prepay
     * The prepay
     */
    public void setPrepay(int prepay) {
        this.prepay = prepay;
    }

    /**
     *
     * @return
     * The user
     */
    public int getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}