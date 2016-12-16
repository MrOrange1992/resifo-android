# Residence Registration Form

In this assignment, you are asked to implement an android app which helps
entering data for a residence registration form ("Meldezettel").
 
The application consists of different screens which make it easy to input
the data. Each screen should contain means to input data in the most comfortable
way, that is the user should not have to type information which could already
be prefilled. For example, there should be a widget for entering the date
of birth.

We are using the official [Meldezettel](http://www.graz.at/cms/dokumente/10024916/e05a999a/Meldezettel.pdf) as
the definition of the app.

## Project Teams

You have the option to work in a team for this assignment. At most, 4 students can work in one team. If you choose
to do so, each team member should have its role explained in a file named "team.md".


## Prototype / Proposal

You have to design a prototype of your app and place it in a pdf named proposal.md in the base of the project directory.
By viewing this md, it should be clear how your application will look like. An estimation on costs should be given
in tabular form which will give an estimation about how long you plan to work on certain aspects of the application.
Think about what your time is worth and give an offer in Euro which describes what a customer would be charged to pay
for your app.

## App Requirements

- The app has a welcome screen.
- The app has a screen where you can switch between "view" and edit data.
- After choosing edit:
  - a wizard like workflow starts where you can enter your data (see the definition of the residence registration form 
   above)
  - on each stage the data is saved to a sqlite database
  - after finishing your work, you return back to the start screen 
- After choosing view:
  - you can view existing data in a summary list (simply a list of firstname / secondname) 
  - you can select a person by clicking on it
  - then you see the details for this person
- Create an interface for deleting the entered data. (list view / detail view of data)
- you can switch back and forth between different screens
- The app persists all data to a local sqlite database
- Use Google Maps Service for entering your current position as the home address.

The app should skip inputs which are not needed to give the user the best user experience possible.

## Formal Requirements

Your app should be hosted in a github repository with the name 'resifo-android'. For each team there will be one
main repository which will serve as the main repository of the team. This has to be communicated on 16.12.2016.

- Your project should have a README.md file in the main directory. In this readme you describe the purpose
of the project for the interested reader; how to setup the project, the prerequisites and the license. For
choosing the right license, the [ChooseALicence](http://choosealicense.com) website can be of great help.
The license should be placed in LICENSE.txt in the main directory of your project. You should be able
to explain why you chose a specific license.

- Your project should have a <code>timesheet.csv</code> in the following form:

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

- give a estimation about how long it will take - how much does it cost?

- deadline for the project itself is 3.2.2016.

## Points
                               
The project is worth 80 points. Like this it is by far the most important part of the lecture and your chance
to show what you have learned during this course. 

The points are given as follows:

10 points .... Timesheets, Team description, Readme, general documentation
10 points .... (Paper) prototype
10 points .... look and feel of your solution
50 points .... implementation