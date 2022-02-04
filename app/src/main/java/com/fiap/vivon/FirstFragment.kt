package com.fiap.vivon

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.fiap.vivon.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cpfCnpj.addTextChangedListener(MaskEditUtil.mask(binding.cpfCnpj))
            binding.buttonFirst.setOnClickListener {
                    when(binding.cpfCnpj.text.length){
                        14 -> {
                            if(checkCpf(binding.cpfCnpj.text.toString())){
                                binding.docCheck.text = "CPF válido"
                                binding.docCheck.setTextColor(Color.GREEN)
                            }
                            else{
                                binding.docCheck.text = "CPF inválido"
                                binding.docCheck.setTextColor(Color.RED)
                            }
                        }
                        18 -> {
                            if(checkCnpj(binding.cpfCnpj.text.toString())){
                                binding.docCheck.text = "CNPJ válido"
                                binding.docCheck.setTextColor(Color.GREEN)
                            }
                            else{
                                binding.docCheck.text = "CNPJ inválido"
                                binding.docCheck.setTextColor(Color.RED)
                            }
                        }
                        else -> {
                            binding.docCheck.text = "Não é um CPF nem CNPJ válido."
                           // binding.docCheck.setTextColor(getColor(R.color.colorAccent))
                        }
                    }
                }

                //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    fun checkCpf(et: String): Boolean{
        var str = et.replace("-", "").replace("/","").replace(".","")
        var calc: Int
        var num = 10
        var sum = 0
        for(x in 0..8) {
            calc = str[x].toString().toInt() * num
            sum += calc
            --num
        }
        var rest = sum % 11
        var test = 11 - rest
        if(test > 9) test = 0
        if(test != str[9].toString().toInt()) return false
        num = 11
        sum = 0
        for(x in 0..9) {
            calc = str[x].toString().toInt() * num
            sum += calc
            --num
        }
        rest = sum % 11
        test = 11 - rest
        if(test > 9) test = 0
        if(test != str[10].toString().toInt()) return false
        return true
    }
    fun checkCnpj(et: String): Boolean{
        var str = et.replace("-", "").replace("/","").replace(".","")
        var calc: Int
        var num = 5
        var sum = 0
        for(x in 0..11) {
            calc = str[x].toString().toInt() * num
            sum += calc
            --num
            if(num == 1) num = 9
        }
        var rest = sum % 11
        var test = 11 - rest
        if(test < 2) test = 0
        if(test != str[12].toString().toInt()) return false
        num = 6
        sum = 0
        for(x in 0..12) {
            calc = str[x].toString().toInt() * num
            sum += calc
            --num
            if(num == 1) num = 9
        }
        rest = sum % 11
        test = 11 - rest
        if(test < 2) test = 0
        if(test != str[13].toString().toInt()) return false
        return true
    }
    object MaskEditUtil {
        fun mask(ediTxt: EditText): TextWatcher {
            var isUpdating: Boolean = false
            var mask = ""
            var old = ""
            return object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val str = unmask(s.toString())
                    var mascara = ""
                    when (str.length) {
                        in 0..11 -> mask = "###.###.###-##"
                        else -> mask = "##.###.###/####-##"
                    }
                    if (isUpdating) {
                        old = str
                        isUpdating = false
                        return
                    }
                    var i = 0
                    for (m in mask.toCharArray()) {
                        if (m != '#' && str.length > old.length) {
                            mascara += m
                            continue
                        }
                        try {
                            mascara += str[i]
                        } catch (e: Exception) {
                            break
                        }
                        i++
                    }
                    isUpdating = true
                    ediTxt.setText(mascara)
                    ediTxt.setSelection(mascara.length)
                }
            }
        }
        fun unmask(s: String): String {
            return s.replace("-", "").replace("/","").replace(".", "")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}