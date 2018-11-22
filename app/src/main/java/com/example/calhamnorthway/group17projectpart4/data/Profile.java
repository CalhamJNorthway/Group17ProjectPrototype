package com.example.calhamnorthway.group17projectpart4.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.calhamnorthway.group17projectpart4.R;

import java.util.Arrays;

public class Profile implements Parcelable {
    private String description;
    private String job;
    private RelationshipStatus relationshipStatus;
    private int[] pictureIds;

    private Profile(Builder builder) {
        description = builder.description;
        job = builder.job;
        relationshipStatus = builder.relationshipStatus;
        pictureIds = builder.pictureIds;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    public String getJob() {
        return job;
    }

    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    public int[] getPictureIds() {
        return pictureIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;

        Profile profile = (Profile) o;

        if (relationshipStatus != profile.relationshipStatus) return false;
        return Arrays.equals(pictureIds, profile.pictureIds);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @SuppressWarnings("WeakerAccess")
    public static final class Builder {
        private String description ="";
        private String job = "";
        private RelationshipStatus relationshipStatus = RelationshipStatus.Single;
        private int[] pictureIds = new int[0];

        private Builder() {
        }

        public Builder setDescription(String val) {
            description = val;
            return this;
        }

        public Builder setJob(String val) {
            job = val;
            return this;
        }

        public Builder setRelationshipStatus1(RelationshipStatus val) {
            relationshipStatus = val;
            return this;
        }

        public Builder withPictureIds(int... val) {
            pictureIds = val;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.job);
        dest.writeInt(this.relationshipStatus == null ? -1 : this.relationshipStatus.ordinal());
        dest.writeIntArray(this.pictureIds);
    }

    @SuppressWarnings("WeakerAccess")
    protected Profile(Parcel in) {
        this.description = in.readString();
        this.job = in.readString();
        int tmpRelationshipStatus = in.readInt();
        this.relationshipStatus = tmpRelationshipStatus == -1 ? null : RelationshipStatus.values()[tmpRelationshipStatus];
        this.pictureIds = in.createIntArray();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
