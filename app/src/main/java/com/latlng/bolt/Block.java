package com.latlng.bolt;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Block implements Parcelable {
        public Integer img;
        public String price;
        public String desc;

        public Block(Integer img, String price, String desc) {
                this.img = img;
                this.price = price;
                this.desc = desc;
        }

        protected Block(Parcel in) {
                if (in.readByte() == 0) {
                        img = null;
                } else {
                        img = in.readInt();
                }
                price = in.readString();
                desc = in.readString();
        }

        public static final Creator<Block> CREATOR = new Creator<Block>() {
                @Override
                public Block createFromParcel(Parcel in) {
                        return new Block(in);
                }

                @Override
                public Block[] newArray(int size) {
                        return new Block[size];
                }
        };

        public Integer getImg() {
                return img;
        }

        public void setImg(Integer img) {
                this.img = img;
        }

        public String getPrice() {
                return price;
        }

        public void setPrice(String price) {
                this.price = price;
        }

        public String getDesc() {
                return desc;
        }

        public void setDesc(String desc) {
                this.desc = desc;
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                if (img == null) {
                        dest.writeByte((byte) 0);
                } else {
                        dest.writeByte((byte) 1);
                        dest.writeInt(img);
                }
                dest.writeString(price);
                dest.writeString(desc);
        }
}
