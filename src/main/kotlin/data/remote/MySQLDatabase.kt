package data.remote

import util.API_URL
import java.lang.Exception
import java.sql.*
import java.util.*

object MySQLDatabase {

    internal var conn: Connection? = null
    internal var username = "root"
    internal var password = "Masters@22"

    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery("SELECT firstname FROM employee;")

            if (stmt.execute("SELECT firstname FROM employee;")) {
                resultset = stmt.resultSet
            }

            while (resultset!!.next()) {
                println(resultset.getString("firstname"))
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx:SQLException){

                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {

                }

                stmt = null
            }

            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {

                }

                conn = null
            }
        }
    }

    fun getConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            conn = DriverManager.getConnection(API_URL,connectionProps)
        } catch (ex: SQLException) {
            println("SQL Exception: ${ex.message}")
        } catch (ex: Exception) {
            println("Exception: ${ex.message}")
        }
    }
}