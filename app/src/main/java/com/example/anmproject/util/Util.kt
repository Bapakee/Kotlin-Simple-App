import android.content.Context
import androidx.room.Room
import com.example.anmproject.model.BudgetingDatabase
import com.example.anmproject.model.ExpensesDatabase
import com.example.anmproject.model.UserDatabase

val DB_NAME = "newuserdb"


fun buildDb(context: Context): UserDatabase {
    val db = UserDatabase.buildDatabase(context)
    return db
}
fun buildBudgetingDb(context: Context): BudgetingDatabase {
    val db = BudgetingDatabase.buildDatabase(context)
    return db
}
fun buildExpensesDb(context: Context): ExpensesDatabase {
    val db = ExpensesDatabase.buildDatabase(context)
    return db
}

