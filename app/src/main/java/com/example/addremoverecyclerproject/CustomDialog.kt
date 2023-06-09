import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.addremoverecyclerproject.DataVO
import com.example.addremoverecyclerproject.MainActivity
import com.example.addremoverecyclerproject.R
import com.example.addremoverecyclerproject.databinding.ActivityMainBinding
import com.example.addremoverecyclerproject.databinding.DialogCustomBinding

class CustomDialog(var context: Context, val mainBinding: ActivityMainBinding) {
    var count: Int = 0
    val dialog = Dialog(context)


    fun showDialog() {
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnSave.setOnClickListener {
            count++
            val tvName = binding.edtName.text.toString()
            val tvAge = binding.edtAge.text.toString()
            val tvEmail = binding.edtEmail.text.toString()
            var dataVO: DataVO? = null
            if (count % 2 == 0) {
                dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.man)
            } else {
                dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.woman)
            }
            (context as MainActivity).refreshRecyclerView(dataVO)
            dialog.dismiss()
        }
    }
}