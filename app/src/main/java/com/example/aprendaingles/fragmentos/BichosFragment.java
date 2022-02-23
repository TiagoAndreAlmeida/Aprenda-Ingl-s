package com.example.aprendaingles.fragmentos;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageButton buttonDog, buttonCat, buttonLion, buttonMonkey, buttonSheep, buttonCow;
    private MediaPlayer mediaPlayer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        buttonDog = view.findViewById(R.id.buttonCao);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonCow = view.findViewById(R.id.buttonCow);
        buttonLion = view.findViewById(R.id.buttonLion);

        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonCow.setOnClickListener(this);
        buttonLion.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCao:
                playSound(R.raw.dog);
                break;
            case R.id.buttonCat:
                playSound(R.raw.cat);
                break;
            case R.id.buttonLion:
                playSound(R.raw.lion);
                break;
            case R.id.buttonSheep:
                playSound(R.raw.sheep);
                break;
            case R.id.buttonMonkey:
                playSound(R.raw.monkey);
                break;
            case R.id.buttonCow:
                playSound(R.raw.cow);
                break;

            default:
                break;
        }
    }

    private void playSound(int soundId) {
        mediaPlayer = MediaPlayer.create(getActivity(), soundId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}