package com.example.calhamnorthway.group17projectpart4.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.calhamnorthway.group17projectpart4.R;

import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class Person implements Parcelable {
    private String name;
    private int age;
    private Gender gender;
    private Profile profile;
    private boolean likesUser;

    public Person(String name, int age, Gender gender, Profile profile, boolean likesUser) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profile = profile;
        this.likesUser = likesUser;
    }

    public Person(String name, int age, Gender gender, Profile profile) {
        this(name, age, gender, profile, false);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Profile getProfile() {
        return profile;
    }

    public boolean likesUser() {
        return likesUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (likesUser != person.likesUser) return false;
        if (!name.equals(person.name)) return false;
        if (gender != person.gender) return false;
        return profile.equals(person.profile);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static final ArrayList<Person> people = new ArrayList<>();

    static {
        createPerson("Aubree", 26, Gender.Female, true,
                "Hello lads! " +
                "I'm learning about important dates in history. Wanna be one of them?\n" +
                "\n" +
                "I'm a lovable kind of gal, who likes nothing more than reading with the right man.\n" +
                "\n" +
                "The first thing people usually notice about me is my remarkable personality, closly " +
                "followed by my smashing eyes. I'm the woman for you, if you like great eyes and moles, " +
                "particularly combined with ample baby oil.",
                "Painter", RelationshipStatus.Single, R.drawable.img_aubree_1);

        createPerson("Evelyn", 21, Gender.Female, false,
                "I am the lawyer you're looking for.\n" +
                "\n" +
                "I'm a charming kinda babe, who likes nothing more than hiking with the right man " +
                "(or men, if I'm lucky - wink wink!).\n" +
                "\n" +
                "The first thing people usually notice about me is my articulate personality, closly " +
                "followed by my smashing moles. You may find yourself awed by the callibre of my moles " +
                "and feet. I will be sure to bring myself well-oiled to our date, so that you can " +
                "appreciate my body to its full.",
                "Lawyer", RelationshipStatus.Divorced, R.drawable.img_evelyn_1, R.drawable.img_evelyn_2);

        createPerson("Lily", 29, Gender.Female, true,
                "I'm a courageous kind of girl, who likes nothing more than hiking with " +
                        "the right woman.\n" +
                        "\n" +
                        "The first thing people usually notice about me is my gentle personality, " +
                        "closly followed by my smashing eyebrows. My friends say I'm very courageous " +
                        "and that I have great eyebrows and acceptable fingers, but what would I know? " +
                        "I just live in this heap of junk they call my body.",
                "Architect", RelationshipStatus.Single, R.drawable.img_lily_1);

        createPerson("Diane", 56, Gender.Female, true,
                "I'm just a humble girl trying to make my way in the world. I cannot imagine " +
                        "why you'd want to date little old me, but if an ordinary, nice bloke is " +
                        "something you think you could find yourself growing to love, I do have all " +
                        "my own teeth and an adequate pension plan." +
                        "\n" +
                        "I work as a navigator, helping blind people. This allows me to exercise " +
                        "my skills: resourcefulness and selling kippers. The most interesting thing " +
                        "that's happened to me at work, is that Hilary Clinton asked me for a sandwich. " +
                        "Of course, I was astounded that such a person would have time for muggins " +
                        "here. Of course, I made the sandwich. ",
                "Navigator", RelationshipStatus.Widowed, R.drawable.img_diane_1, R.drawable.img_diane_2);

        createPerson("Elizabeth", 32, Gender.Female, true,
                "Honesty and openness are the most important qualities in a relationship. " +
                        "I will be honest with you, if you will be honest with me. I will never hit " +
                        "on your best friend whilst you're visiting a sick relative, never text my " +
                        "ex behind your back while you're asleep, never post naked photos of you on " +
                        "Facebook. That's just the kind of lady I am.",
                "HouseKeeper", RelationshipStatus.Engaged, R.drawable.img_elizabeth_1);

        createPerson("Robin", 39, Gender.Female, false,
                "People only get one chance with me. For every person who displeases me, " +
                        "there are another 111 waiting in the wings to replace you.",
                "Librarian", RelationshipStatus.Single, R.drawable.img_robin_1);

        createPerson("Gordon", 34, Gender.Male, true,
                "To only the best people out there,\n" +
                        "\n" +
                        "I'm a splendid kinda man, who likes nothing more than reading with the " +
                        "right person, and socialising with my good mate, James Corden, who admires " +
                        "my brave qualities.\n" +
                        "\n" +
                        "The first thing people usually notice about me is my grateful personality, " +
                        "closly followed by my smashing eyebrows. I can be a jerk when I don't know " +
                        "people well - with body parts like my eyebrows and my eyebrows, I can afford to be.",
                "Author", RelationshipStatus.Relationship, R.drawable.img_gordon_1);

        createPerson("Bob", 67, Gender.Male, false,
                "Just an Old man doing Old man stuff",
                "Being Old", RelationshipStatus.Widowed, R.drawable.img_bob_1, R.drawable.img_bob_2);

        createPerson("Justin", 27, Gender.Male, false,
                "Hope the shed got some red.\n" +
                        "My bed don't like no dirty lead.\n" +
                        "Run up to the read and get the spread.\n" +
                        "In a New York state of mind.\n" +
                        "\n" +
                        "What more could you ask for? The sweaty friend?\n" +
                        "You complain about famine.\n" +
                        "I gotta love it though - somebody still speaks for the end.",
                "Song Writer", RelationshipStatus.Single, R.drawable.img_justin_1);

        createPerson("Lucas", 35, Gender.Male, true,
                "The right man's smile will light up my day like somebody igniting a " +
                        "sparkler on a particularly stormy November 5th. Your greasy toenails will " +
                        "make me tremble like sitting on a park bench when a double decker bus " +
                        "rattles by." +
                        "\n" +
                        "My idol is Michael Caine. When I'm struggling with my job, I think of " +
                        "Michael Caine and feel inspired to continue. I once saw Michael Caine at a petrol station, " +
                        "so I feel we have a deep connection - almost spiritual, like the mist on an autumn day, or similar.",
                "Photographer", RelationshipStatus.Divorced, R.drawable.img_lucas_1);

        createPerson("Shawn", 31, Gender.Male, true,
                "I work as a teacher, helping vulnerable adults." +
                        "My ideal date would involve choir in Africa with a hairy person by my side. " +
                        "While we're there, I admire your sticky arms, hoping to myself that you're " +
                        "not another nutter.\n" +
                        "\n" +
                        "In case I haven't made myself clear, people have hurt me in the past - " +
                        "bad. My last partner nailed my grandmother to a spike. Now I'm looking for " +
                        "a articulate person with sticky arms, as I read in a magazine that they are " +
                        "the least evil.",
                "Teacher", RelationshipStatus.Complicated, R.drawable.img_shawn_1);
    }

    private static void createPerson(String name, int age, Gender gender, boolean likesUser, String description,
                              String job, RelationshipStatus relationshipStatus, int... pictureIds) {
        Profile profile = Profile.newBuilder()
                .setDescription(description)
                .setJob(job)
                .setRelationshipStatus1(relationshipStatus)
                .withPictureIds(pictureIds)
                .build();
        Person person = new Person(name, age, gender, profile, likesUser);
        people.add(person);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeInt(this.gender == null ? -1 : this.gender.ordinal());
        dest.writeParcelable(this.profile, flags);
        dest.writeByte(this.likesUser ? (byte) 1 : (byte) 0);
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        int tmpGender = in.readInt();
        this.gender = tmpGender == -1 ? null : Gender.values()[tmpGender];
        this.profile = in.readParcelable(Profile.class.getClassLoader());
        this.likesUser = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
