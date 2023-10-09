
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.amandeep.jetpackcompose.ui.activity.BankInputField
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BankForm(bankFormViewModel: BankFormViewModel = viewModel()) {

    val state = bankFormViewModel.uiState.value

    val context = LocalContext.current

    val localFocus = LocalFocusManager.current

    var ownerNameTextState by remember { mutableStateOf("") }

    LaunchedEffect(key1 = context) {
        bankFormViewModel.validationEvent.collect { event ->
            when(event) {
                is ValidationEvent.Success -> {
                    Toast.makeText(context,"All inputs are valid", Toast.LENGTH_SHORT).show()
                }
                else -> {

                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BankInputField(
            label = "Account number",
            onTextChanged = {
                bankFormViewModel.onEvent(UIEvent.AccountChanged(it))
            },
            keyboardType = KeyboardType.Number,
            isError = state.hasAccountError,
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {

            }
        )
        BankInputField(
            label = "Confirm account number",
            onTextChanged = {
                bankFormViewModel.onEvent(UIEvent.ConfirmAccountChanged(it))
            },
            keyboardType = KeyboardType.NumberPassword,
            isError = state.hasConfirmAccountError,
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {}
        )
        BankInputField(
            label = "Bank Code",
            onTextChanged = {
                bankFormViewModel.onEvent(UIEvent.CodeChanged(it))
            },
            isError = state.hasCodeError,
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {}
        )
        BankInputField(
            label = "Owner name",
            onTextChanged = {
                ownerNameTextState = it
                bankFormViewModel.onEvent(UIEvent.NameChanged(it))
            },
            isError = state.hasNameError,
            imeAction = ImeAction.Done,
            onNext = {},
            onDone = {
                localFocus.clearFocus()
            }
        )

        // New OutlinedTextField for Owner Name
        OutlinedTextField(
            value = ownerNameTextState,
            onValueChange = {
                // Update the ownerNameTextState when the text changes
                ownerNameTextState = it
            },
            label = {
                Text("Owner name")
            },
            isError = state.hasNameError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    localFocus.clearFocus()
                }
            )
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                bankFormViewModel.onEvent(UIEvent.Submit)
            },
        ) {
           Text("Submit")
        }
    }
}