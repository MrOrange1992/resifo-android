package at.reservoirdogs.resifo_android.dataBase

/**
  * Created by felix on 01/02/2017.
  */
class Residence(iStreet: String, iHouseNumber: Int, iStairs: Int, iDoor: Int, iPlz: Int, iCity: String, iState: String)
{
  private var state:String = iState
  private var city:String = iCity
  private var plz:Int = iPlz
  private var street:String = iStreet
  private var houseNumber:Int = iHouseNumber
  private var stairs:Int = iStairs
  private var door:Int = iDoor
  private var isMainResidence = false
  private var isActive = false

  def getState = state
  def getCity = city
  def getPlz = plz
  def getStreet = street
  def getHouseNumber = houseNumber
  def getStairs = stairs
  def getDoor = door
  def getMainResidence = isMainResidence
  def getActive = isActive

  def setState (sState:String) = {
    this.state = sState
  }
  def setCity (sCity:String) = {
    this.city = sCity
  }
  def setPlz (sPlz:Int) = {
    this.plz = sPlz
  }
  def setStreet (sStreet:String) = {
    this.street = sStreet
  }
  def setHouseNumber (sHouseNumber:Int) = {
    this.houseNumber = sHouseNumber
  }
  def setStairs (sStairs:Int) = {
    this.stairs = sStairs
  }
  def setDoor (sDoor:Int) = {
    this.door = sDoor
  }
  def setMainResidence (sResidence:Boolean) = {
    this.isMainResidence = sResidence
  }
  def setActive (sActive:Boolean) = {
    this.isActive = sActive
  }

}
