package at.reservoirdogs.resifo_android.dataBase

/**
  * Created by felix on 01/02/2017.
  */
class Person(val firstName: String, val lastName: String)
{
  var degree: String = ""
  //var birthDate: ((Short,Short),(Short,Short),(Short,Short)) = ()
  var birthDate: String = ""
  var gender: String = ""
  var religion: String = ""
  var birthPlace: String = ""
  var maritalStatus: String = ""
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
