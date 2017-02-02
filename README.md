## App Requirements

- The app has a welcome screen.
- The app has a screen where you can switch between "view" and edit new data.
- After choosing edit:
  - a wizard like workflow starts where you can enter your data (see the definition of the residence registration form
   above)
  - on each stage the data is saved to a sqlite database
  - after finishing your work, you return back to the start screen
- you can switch back and forth between different screens
- The app persists all data to a local sqlite database
- Create an Interface for viewing and deleting the entered data. (list view / detail view of data)
- Use Google Maps Service for entering your current position as the home address.

The app should skip inputs which are not needed to give the user the best user experience possible.

## Formal Requirements

Your app should be hosted in a github repository with the name 'android-resifo'. For each team there will be one
main repository which will serve as the main repository of the team. This has to be communicated on 16.12.2016.

- Your project should have a README.md file in the main directory. In this readme you describe the purpose
of the project for the interested reader; how to setup the project, the prerequisites and the license. For
choosing the right license, the [ChooseALicence](http://choosealicense.com) website can be of great help.
The license should be placed in LICENSE.txt in the main directory of your project. You should be able
to explain why you chose a specific license.

- Your project should have a <code>Timesheet.csv</code> in the following form:

<pre>
Person;Date;Hours;Description
rladstaetter;20161224;10;Setup of project
</pre>

That means that in the first line of this file there is a header ('Date;Hours;Description') and then, on every line each,
a description of the activity and the hours spend on that activity (and the day when this happened.). The first column
is your shortname, consisting of the first letter of your firstname and afterwards your second name in lower letters.

- your project has a file named 'proposal.md' which makes clear what will be delivered.

- After finishing your work and the assignment, you should create file 'postmortem.md' where you describe what where
the main problems in the project and what you learned from it.

- the project paper prototype has to be delivered at latest on 23.12.2016

- deadline for the project itself is 3.2.2016.


Purpose of the Project

How to setup the project

prerequisites

license
http://choosealicense.com/licenses/mit/
MIT License was chosen, because we wanted to keep it simple and it is a non-commercial project.
We want to be credited if someone does further development but not be held liable.
