package com.IngesPous.minitec.data.repository

import android.R.attr.resource
import com.IngesPous.minitec.data.repository.dataSource.AuthRemoteDataSource
import com.IngesPous.minitec.domain.model.AuthResponse
import com.IngesPous.minitec.domain.model.ErrorResponse

import com.IngesPous.minitec.domain.repository.AuthRepository
import com.IngesPous.minitec.domain.util.ConvertErrorBody
import com.IngesPous.minitec.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException


class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            if (result.isSuccessful){
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse : ErrorResponse? = ConvertErrorBody.convertErrorBody(result.errorBody())
                Resource.Failure(errorResponse?.message?: "Error desconocido")
            }

        }
        catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticion Http")

        }
        catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("verifica tu conexion a internet")
        }
        catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }
}