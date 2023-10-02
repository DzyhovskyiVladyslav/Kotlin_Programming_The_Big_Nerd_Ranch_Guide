package com.example.mytrainingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytrainingapp.databinding.NewCharacterActivityBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: NewCharacterActivityBinding
private var characterData = CharacterGenerator.generate()
private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"
private var Bundle.characterData
    get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
    set(value) = putSerializable(CHARACTER_DATA_KEY, value)


class NewCharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewCharacterActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        characterData = savedInstanceState?.characterData ?:
                CharacterGenerator.generate()
        binding.generateButton.setOnClickListener {
            launch(UI) {
                characterData = fetchCharacterData().await()
                displayCharacterData()
            }
        }
        displayCharacterData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.characterData = characterData
    }

    private fun displayCharacterData() {
        characterData.run {
            binding.nameTextView.text = name
            binding.raceTextView.text = race
            binding.dexterityTextView.text = dex
            binding.wisdomTextView.text = wis
            binding.strengthTextView.text = str
        }
    }
}