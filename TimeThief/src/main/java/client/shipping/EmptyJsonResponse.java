package client.shipping;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmptyJsonResponse {
	// Til að actually returna JSON object í staðinn fyrir null
	// sem Volley sendir í onFailure handlerinn með JSON parse error.
}
