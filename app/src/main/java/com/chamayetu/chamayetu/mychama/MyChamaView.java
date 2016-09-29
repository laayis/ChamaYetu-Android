package com.chamayetu.chamayetu.mychama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chamayetu.chamayetu.R;
import com.chamayetu.chamayetu.utils.Contract;
import com.chamayetu.chamayetu.utils.models.ChamaPojo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ChamaYetu
 * com.chamayetu.chamayetu.mychama
 * Created by lusinabrian on 28/09/16.
 * Description: View that will handle Chama Details and data for the user's chama
 */

public class MyChamaView extends Fragment {
    public static final String MYCHAMA_TAG = MyChamaView.class.getSimpleName();

    @BindView(R.id.mychamastatement_card) CardView statementCard;
    @BindView(R.id.mychamaagenda_card) CardView agendaCard;
    @BindView(R.id.mychamamembers_card) CardView membersCard;
    @BindView(R.id.mychamanxtmeeting_card) CardView nxtMeetingCard;
    @BindView(R.id.statement_from_field) TextView dateFrom;
    @BindView(R.id.statement_to_field) TextView dateTo;
    @BindView(R.id.nxtmeeting_time_field) TextView nxtMeetingTime;
    @BindView(R.id.nxtmeeting_venue_field) TextView nxtMeetingVenue;
    @BindView(R.id.milestone_field) TextView milestioneView;
    @BindView(R.id.members_number) TextView memberNumbers;

    private DatabaseReference mDatabase;

    public MyChamaView() {}

    public static Fragment newInstance(){
        MyChamaView myChamaView = new MyChamaView();
        myChamaView.setRetainInstance(true);
        return myChamaView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mychama_view, container, false);
        ButterKnife.bind(rootView);
        initFirebaseDatabase();
        return rootView;
    }

    /**Initialize Firebase Database*/
    private void initFirebaseDatabase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(Contract.CHAMA_NODE).child("boda").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ChamaPojo chamaPojo = dataSnapshot.getValue(ChamaPojo.class);

                chamaPojo = new ChamaPojo(chamaPojo.getDateCreated(),
                        chamaPojo.getMilesteoneDate(), chamaPojo.getNextMeetingTime(),
                        chamaPojo.getMilesteoneDate(), chamaPojo.getMembers(),
                        chamaPojo.getTotalAmount(),chamaPojo.getAmountExpected(),
                        chamaPojo.getName(),chamaPojo.getVenue(),chamaPojo.getMilestone());
                Log.d(MYCHAMA_TAG,chamaPojo.toString());

                nxtMeetingTime.setText((int) chamaPojo.getNextMeetingTime());
                nxtMeetingVenue.setText(chamaPojo.getVenue());
                milestioneView.setText(chamaPojo.getMilestone());
                memberNumbers.setText((int) chamaPojo.getMembers());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
