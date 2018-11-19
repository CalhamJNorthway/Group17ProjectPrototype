package com.example.calhamnorthway.group17projectpart4.data;

public class Profile {
    private String description;
    private String job;
    private String martialStatus;
    private int[] pictureIds;

    private Profile(Builder builder) {
        description = builder.description;
        job = builder.job;
        martialStatus = builder.martialStatus;
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

    public String getMartialStatus() {
        return martialStatus;
    }

    public int[] getPictureIds() {
        return pictureIds;
    }

    public static final class Builder {
        private String description;
        private String job;
        private String martialStatus;
        private int[] pictureIds;

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

        public Builder setMartialStatus(String val) {
            martialStatus = val;
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
}
