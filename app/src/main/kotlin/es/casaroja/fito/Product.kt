package es.casaroja.fito

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.microstream.RootProvider
import io.micronaut.microstream.annotations.StoreParams
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.concurrent.*
import javax.validation.Valid

data class Product(
    @JsonProperty("IdProducto")
    var productId: Int,
    @JsonProperty("CodInternoFabricante")
    var internalManufacturerCode: String?,
    @JsonProperty("NumRegistro")
    var registryNumber: String,
    @JsonProperty("Nombre")
    var name: String,
    @JsonProperty("Titular")
    var registrant: String,
    @JsonProperty("Fabricante")
    var manufacturer: String,
    @JsonProperty("Fabrica")
    var plant: Int?,
    @JsonProperty("Formulado")
    var formulation: String,
    @JsonProperty("Estado")
    var legalStatus: String,
    @JsonProperty("Observaciones")
    var notes: String?,
    @JsonProperty("Tramite")
    var tramite: String?,
    @JsonProperty("EstadoTramite")
    var estadotramite: String?,
    @JsonProperty("Condicionamiento")
    var conditioning: String?,
    @JsonProperty("Simbolo_1")
    var symbol1: String?,
    @JsonProperty("Simbolo_2")
    var symbol2: String?,
    @JsonProperty("Simbolo_3")
    var symbol3: String?,
    @JsonProperty("Domestico")
    var domestic: String?,
    @JsonProperty("Seg_Almacenamiento")
    var storageSafety: String?,
    @JsonProperty("Seg_Manipulacion")
    var handlingSafety: String?,
    @JsonProperty("Version")
    var version: String?,
    @JsonProperty("VersionDePartida")
    var origVersion: String?,
    @JsonProperty("Seg_Des_Vertido")
    var disposalSafety: String?,
    @JsonProperty("NRegDirectiva")
    var nregDirectiva: String?,
    @JsonProperty("EstadoVersion")
    var versionState: String?,
    @JsonProperty("IdEstado")
    var stateId: String?,
    @JsonProperty("IdSustancia")
    var substanceId: String?,
    @JsonProperty("IdAmbito")
    var envId: String?,
    @JsonProperty("IdCultivo")
    var cropId: String?,
    @JsonProperty("IdPlaga")
    var plagueId: String?,
    @JsonProperty("IdFuncion")
    var functionId: String?,
    @JsonProperty("IdTitular")
    var titularId: String?,
    @JsonProperty("IdFormulado")
    var formulationId: Int?,
    @JsonProperty("FechaTramite")
    var requestDate: String?,
    @JsonProperty("StrFechaTramite")
    var strRequestDate: String?,
    @JsonProperty("FechaCaducidad")
    var expiryDate: String?,
    @JsonProperty("StrFechaCaducidad")
    var strExpiryDate: String?,
    @JsonProperty("FechaInscripcion")
    var registryDate: String?,
    @JsonProperty("StrFechaInscripcion")
    var strRegistryDate: String?,
    @JsonProperty("FechaRenovacion")
    var renewalDate: String?,
    @JsonProperty("StrFechaRenovacion")
    var strRenewalDate: String?,
    @JsonProperty("FechaModificacion")
    var updateDate: String?,
    @JsonProperty("StrFechaModificacion")
    var strUpdateDate: String?,
    @JsonProperty("FechaLimiteVenta")
    var saleLimitDate: String?,
    @JsonProperty("StrFechaLimiteVenta")
    var strSDaleLimitDate: String?,
    @JsonProperty("FechaAutorizacion")
    var authorizationDate: String?,
    @JsonProperty("StrFechaAutorizacion")
    var strAuthorizationDate: String?,
) {
}

@Introspected
class ProductContainer {
    val products: MutableMap<Int, Product> = ConcurrentHashMap()
}

interface ProductRepository {
    fun list(): Collection<Product>
    fun create(@Valid product: Product): Product
    fun find(productId: Int): Product?
}

@Singleton
open class ProductContainerRepo : ProductRepository {
    @Inject
    private lateinit var rootProvider: RootProvider<ProductContainer>

    override fun list() = rootProvider.root().products.values

    override fun create(product: Product): Product {
        return performCreate(rootProvider.root().products, product)
    }

    @StoreParams("products")
    protected open fun performCreate(
        products: MutableMap<Int, Product>,
        product: Product,
    ): Product {
        products[product.productId] = product
        return product
    }

    override fun find(productId: Int):Product? = rootProvider.root().products[productId]
}
