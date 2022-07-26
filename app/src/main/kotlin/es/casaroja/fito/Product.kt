package es.casaroja.fito

import com.fasterxml.jackson.annotation.JsonProperty

data class FitoProduct(
    @JsonProperty("IdProducto")
    var productId:Int,
    @JsonProperty("CodInternoFabricante")
    var internalManufacturerCode:String?,
    @JsonProperty("NumRegistro")
    var registryNumber:String,
    @JsonProperty("Nombre")
    var name:String,
    @JsonProperty("Titular")
    var registrant:String,
    @JsonProperty("Fabricante")
    var manufacturer:String,
    @JsonProperty("Fabrica")
    var plant:Int?,
    @JsonProperty("Formulado")
    var formulation:String,
    @JsonProperty("Estado")
    var legalStatus:String,
    @JsonProperty("Observaciones")
    var notes:String?,
    @JsonProperty("Tramite")
    var tramite:String?,
    @JsonProperty("EstadoTramite")
    var estadotramite:String?,
    @JsonProperty("Condicionamiento")
    var conditioning:String?,
    @JsonProperty("Simbolo_1")
    var symbol1:String?,
    @JsonProperty("Simbolo_2")
    var symbol2:String?,
    @JsonProperty("Simbolo_3")
    var symbol3:String?,
    @JsonProperty("Domestico")
    var domestic:String?,
    @JsonProperty("Seg_Almacenamiento")
    var storageSafety:String?,
    @JsonProperty("Seg_Manipulacion")
    var handlingSafety:String?,
    @JsonProperty("Version")
    var version:String?,
    @JsonProperty("VersionDePartida")
    var origVersion:String?,
    @JsonProperty("Seg_Des_Vertido")
    var disposalSafety:String?,
    @JsonProperty("NRegDirectiva")
    var nregDirectiva:String?,
    @JsonProperty("EstadoVersion")
    var versionState:String?,
    @JsonProperty("IdEstado")
    var stateId:String?,
    @JsonProperty("IdSustancia")
    var substanceId:String?,
    @JsonProperty("IdAmbito")
    var envId:String?,
    @JsonProperty("IdCultivo")
    var cropId:String?,
    @JsonProperty("IdPlaga")
    var plagueId:String?,
    @JsonProperty("IdFuncion")
    var functionId:String?,
    @JsonProperty("IdTitular")
    var titularId:String?,
    @JsonProperty("IdFormulado")
    var formulationId:Int?,
    @JsonProperty("FechaTramite")
    var requestDate:String?,
    @JsonProperty("StrFechaTramite")
    var strRequestDate:String?,
    @JsonProperty("FechaCaducidad")
    var expiryDate:String?,
    @JsonProperty("StrFechaCaducidad")
    var strExpiryDate:String?,
    @JsonProperty("FechaInscripcion")
    var registryDate:String?,
    @JsonProperty("StrFechaInscripcion")
    var strRegistryDate:String?,
    @JsonProperty("FechaRenovacion")
    var renewalDate:String?,
    @JsonProperty("StrFechaRenovacion")
    var strRenewalDate:String?,
    @JsonProperty("FechaModificacion")
    var updateDate:String?,
    @JsonProperty("StrFechaModificacion")
    var strUpdateDate:String?,
    @JsonProperty("FechaLimiteVenta")
    var saleLimitDate:String?,
    @JsonProperty("StrFechaLimiteVenta")
    var strSDaleLimitDate:String?,
    @JsonProperty("FechaAutorizacion")
    var authorizationDate:String?,
    @JsonProperty("StrFechaAutorizacion")
    var strAuthorizationDate:String?,
) {
}
