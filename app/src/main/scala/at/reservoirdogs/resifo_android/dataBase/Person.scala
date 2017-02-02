package at.reservoirdogs.resifo_android.dataBase

import java.util
import java.util.Date


/**
  * Created by felix on 01/02/2017.
  */
class Person(val iFirstName:String, val iLastName:String)
{

  private var degree: String = ""
  //var birthDate: ((Short,Short),(Short,Short),(Short,Short)) = ()
  private var birthDate: Date = new Date()
  private var gender: String = ""
  private var religion: String = ""
  private var birthPlace: String = ""
  private var maritalStatus: String = ""
  private var firstname = iFirstName
  private var lastname = iLastName
  private var residences:util.ArrayList[Residence] = new util.ArrayList[Residence]()

  def getBirthDate = birthDate
  def getDegree = degree
  def getGender = gender
  def getReligion = religion
  def getBirthPlace = birthPlace
  def getMaritalStatus = maritalStatus
  def getFirstName = firstname
  def getLastName = lastname
  def getResidence = residences

  def setFirstName(sFirstName:String) = {
    this.firstname = sFirstName
  }
  def setLastName(sLastName:String) = {
    this.lastname = sLastName
  }
  def setBirthDate(sBirthDate: Date) = {
    this.birthDate = sBirthDate
  }
  def setGender(sGender:String) = {
    this.gender = sGender
  }
  def setDegree(sDegree:String) = {
    this.degree = sDegree
  }
  def setReligion(sReligion:String) = {
    this.religion = sReligion
  }
  def setBirthPlace(sBirthPlace:String) = {
    this.birthPlace = sBirthPlace
  }
  def setMaritalStatus(sMaritalStatus:String)= {
    this.maritalStatus = sMaritalStatus
  }

  def addResidence(residence:Residence) = {
    this.residences.add(residence)
  }
  def removeResidence(index:Int) = {
    this.residences.remove(index)
  }
  def getResidenceAt(index:Int) = {
    this.residences.get(index)
  }

  /*
  var nationality: String
  var zmr: String
  var docType: String
  var docNumber: String
  //var docDate: ((Short,Short),(Short,Short),(Short,Short)) = ()
  var docDate: String
  var docNation: String
  //Residence can be registering or deregistering depending on Bool registering
  var residence: Residence
  //Optional, only if Person is registering
  var mainResidence: Residence
  var immigrant: Boolean
  //Optional if depending on Bool immigrant
  var immigrationCountry: String
  */
}
