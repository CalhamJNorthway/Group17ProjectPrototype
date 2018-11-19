package com.example.calhamnorthway.group17projectpart4.data;

import com.example.calhamnorthway.group17projectpart4.R;

public class Profile {
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
}
