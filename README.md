# otstest

## The app

The aim of this application is to monitor when the device boots up and to set up a repeating task
for displaying notifications containing boot event details. Users can dismiss these notifications,
which will prompt the app to reschedule them accordingly.

## What was done
1. Added libs.
2. Added modules
3. Added architecture (based on SOLID and Clean architecture).
4. Added receiver for getting events.
5. Added db for saving events.

## TODO list

1. Create a dialog to display information about the boot event.
2. Create a worker for the scheduler to show the dialog with event information.
3. Add a variable to preferences with a default time (15 minutes) that will be displayed on the main
   screen. Add a picker to change this value when clicked.
4. Create a database to save data on when the dialog with event information was shown.
5. Add logic to adjust the display time based on the dialog display count.
6. Add unit tests.
7. Add text in string.
8. Add styles.
10. Add ci/cd
11. etc
