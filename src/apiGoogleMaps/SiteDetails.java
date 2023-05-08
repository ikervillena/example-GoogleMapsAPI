package apiGoogleMaps;

import com.google.maps.GeocodingApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

public class SiteDetails {

    private static String apiKey = "API_KEY";

    public static String[] getDetails(String address) throws IOException, InterruptedException, ApiException {
        // Crear el contexto de la API de Google Maps
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();

        // Geocodificar la dirección dada
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();

        // Obtener el primer resultado de la geocodificación
        GeocodingResult result = results[0];

        // Obtener informacion sobre la dirección dada
        String ciudad = ""; String pais = ""; String codPostal = "";
        String dirFormateada = result.formattedAddress;
        LatLng location = result.geometry.location;
        String latitud = String.valueOf(location.lat);
        String longitud = String.valueOf(location.lng);

        for (AddressComponent component : result.addressComponents) {
            AddressComponentType[] types = component.types;
            for (AddressComponentType type : types) {
                switch (type) {
                    case COUNTRY:
                        pais = component.longName;
                        String codPais = component.shortName;
                        break;
                    case ADMINISTRATIVE_AREA_LEVEL_1:
                        String provincia = component.longName;
                        break;
                    case LOCALITY:
                        ciudad = component.longName;
                        break;
                    case POSTAL_CODE:
                        codPostal = component.longName;
                        break;
                    default:
                        break;
                }
            }
        }
        String idLugar = result.placeId;

        // Devolver un array con los detalles de la dirección (no se devuelven todos los obtenidos)
        return new String[]{ciudad, pais, codPostal, latitud};
    }

}
