package  com.example.comum.data.model.authApi

import com.auth0.android.jwt.JWT
import java.util.*

data class TokenResponse(
    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    val refresh_token: String,
    val refresh_token_expires_in: Int
) {

    fun getJwtInfo(): JWT =  JWT(access_token)

    fun expirationDate(): Date?{
        val jwt = getJwtInfo()
        return jwt.expiresAt
    }
}