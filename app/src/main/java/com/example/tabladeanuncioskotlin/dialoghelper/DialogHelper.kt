package com.example.tabladeanuncioskotlin.dialoghelper

import android.app.AlertDialog
import android.view.View
import com.example.tabladeanuncioskotlin.MainActivity
import com.example.tabladeanuncioskotlin.R
import com.example.tabladeanuncioskotlin.databinding.SignDialogBinding

class DialogHelper(act:MainActivity) {
    //Sukurti registravimo, iejimo dialogo langams
   private val act = act

    fun createSignDialog(index:Int){
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        builder.setView(rootDialogElement.root)
        val dialog = builder.create()
       setDialpgState(index, rootDialogElement)

        rootDialogElement.btSignUpIn.setOnClickListener{
                    dialog.dismiss()
        }


dialog.show()


    }

    private fun setDialpgState(index: Int, rootDialogElement: SignDialogBinding) {
        //Dialogo busena:Registracijai ar iejimui
        if (index == DialogConst.SIGN_UP_STATE){
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.ac_sign_up)
            rootDialogElement.btSignUpIn.text = act.resources.getString(R.string.sign_up_action)
        }else{
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.ac_sign_in)
            rootDialogElement.btSignUpIn.text = act.resources.getString(R.string.sign_in_action)
            rootDialogElement.btForgetP.visibility =View.VISIBLE
        }
    }
}