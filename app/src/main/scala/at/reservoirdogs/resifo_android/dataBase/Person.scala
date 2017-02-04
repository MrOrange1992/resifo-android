package at.reservoirdogs.resifo_android.dataBase

import java.util
import java.util.Date


/**
  * Created by felix on 01/02/2017.
  */
class Person(val iFirstName:String, val iLastName:String) extends Serializable
{
  //ATTRIBUTES
  //------------------------------------------------------------------------------------------------
  private var degree: String = ""
  //var birthDate: ((Short,Short),(Short,Short),(Short,Short)) = ()
  private var birthDate: Date = new Date()
  private var gender: String = ""
  private var religion: String = ""
  private var birthPlace: String = ""
  private var maritalStatus: String = ""
  private var firstname = iFirstName
  private var lastname = iLastName
  private var residences: util.ArrayList[Residence] = new util.ArrayList[Residence]()
  private var nationality: String = ""
  private var zmr: String = ""
  private var docType: String = ""
  private var docNumber: String = ""
  private var docDate: String = ""
  private var docNation: String = ""
  //Residence can be registering or deregistering depending on Bool registering
  private var immigrant: Boolean = false
  //Optional if depending on Bool immigrant
  private var immigrationCountry: String = ""
  //------------------------------------------------------------------------------------------------



  //GETTER SETTER
  //------------------------------------------------------------------------------------------------
  def getBirthDate = birthDate
  def getDegree = degree
  def getGender = gender
  def getReligion = religion
  def getBirthPlace = birthPlace
  def getMaritalStatus = maritalStatus
  def getFirstName = firstname
  def getLastName = lastname
  def getResidence = residences
  def getNationality = nationality
  def getZMR = zmr
  def getDocType = docType
  def getDocNumber = docNumber
  def getDocDate = docDate
  def getDocNation = docNation
  def getImmigrant = immigrant
  def getImmigrantCountry = immigrationCountry
  def setFirstName(sFirstName:String) = { this.firstname = sFirstName }
  def setLastName(sLastName:String) = { this.lastname = sLastName }
  def setBirthDate(sBirthDate: Date) = { this.birthDate = sBirthDate }
  def setGender(sGender:String) = { this.gender = sGender }
  def setDegree(sDegree:String) = { this.degree = sDegree }
  def setReligion(sReligion:String) = { this.religion = sReligion }
  def setBirthPlace(sBirthPlace:String) = { this.birthPlace = sBirthPlace }
  def setMaritalStatus(sMaritalStatus:String)= { this.maritalStatus = sMaritalStatus }
  def addResidence(residence:Residence) = { this.residences.add(residence) }
  def removeResidence(index:Int) = { this.residences.remove(index) }
  def getResidenceAt(index:Int) = { this.residences.get(index) }
  def setNationality(sNationality:String) = { this.nationality = sNationality }
  def setZMR(sZMR:String) = { this.zmr = sZMR }
  def setDocType(sDocType:String) = { this.docType = sDocType }
  def setDocNumber(sDocNumber:String) = { this.docNumber = sDocNumber }
  def setDocDate(sDocDate:String) = { this.docDate = sDocDate }
  def setDocNation(sDocNation:String) = { this.docNation = sDocNation }
  def setImmigrant(sImmigrant:Boolean) = { this.immigrant = sImmigrant }
  def setImmigrantCountry(sImmigrantCountry:String) = { this.immigrationCountry = sImmigrantCountry }
  //------------------------------------------------------------------------------------------------

}
