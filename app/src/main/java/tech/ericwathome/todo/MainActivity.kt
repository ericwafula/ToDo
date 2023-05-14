package tech.ericwathome.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import tech.ericwathome.todo.feature_note.presentation.all_notes.AllNotesScreen
import tech.ericwathome.todo.navigation.Route
import tech.ericwathome.todo.ui.theme.ToDoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoTheme {
                val navController = rememberNavController()

                Scaffold { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.ALL_NOTES
                    ) {
                        composable(route = Route.ALL_NOTES) {
                            AllNotesScreen(
                                modifier = Modifier.padding(paddingValues),
                                onClickAddNote = {
                                    navController.navigate("${Route.EDIT_NOTE}/?id=$id")
                                },
                                onClickNote = { id ->
                                    navController.navigate("${Route.EDIT_NOTE}/?id=$id")
                                }
                            )
                        }

                        composable(route = "${Route.EDIT_NOTE}/?id={id}", arguments = listOf(
                            navArgument("id") { type = NavType.IntType }
                        )) {

                        }
                    }
                }
            }
        }
    }
}