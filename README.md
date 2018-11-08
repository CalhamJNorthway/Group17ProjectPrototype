# Group17 Project - Part4

Collaborators: <br>
| | Name: Calham Northway | | Student Number: 50517151 | | <br>
| | Name: Christopher Beda  | | Student Number: 29732096 | |


### Navigation Architecture Components
Android Studio Version Requirement: 3.2 <br>
To enable the Navigation Editor follow the steps here:
https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing#Set-up

If Android Studio is not 3.2, you will not be able to use the Navigation
Editor. This editor allows it easier to setup the navigation between fragments.

The main parts are covered in this documentation:
https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing

#### The need to know parts of the Navigation Architecture Components
You can find the navigation.xml in res/navigation. Opening up the xml
in Android studio when the the navigation editor is enabled will have 2 tabs
in the editor, Design and Text. All work can be done under the Design tab.

To create a new destination there is a + button in the upper left part of the
editor screen. Clicking that will drop down a menu that you can select existing
fragments or you can use it to create a new destination. Selecting create new
destination, the android studio wizard will appear with the creation of a new
fragment. Name the fragment and select Create xml layout, you may or may not select
Include fragment factory method, select Include interaction callback. Click finish to
create the new destination.

Destinations are connected using actions. To connect two destinations:
https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing#Connect-destinations

Navigating to a destination is done using the NavController class. To tie
destinations to a UI widget:
https://developer.android.com/topic/libraries/architecture/navigation/navigation-implementing#Tie-ui

Another option is in the fragment interaction callback method in the Main Activity, you may call
```java
    navController.navigate(R.id.action_yourAction);
```


For example in the main activity it would look something like this, if going
from the meetPeopleFragment to profileDetailsFragment.  Because the onGoToProfile()
is meetPeopleFragment interaction callback, you may call onGoToProfile()
on the interaction callback
```java
Meet People Fragment

    if (mListener != null) {
        mListener.onGoToProfile();
    }


Main Activity

    @Override
    public void onGoToProfile() {
        navController.navigate(R.id.action_meetPeopleFragment_to_profileDetailsFragment);
    }
```

For navigating to work between two destinations a connection must be
connecting the two destinations with an action.