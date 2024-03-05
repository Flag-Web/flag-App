package com.example.myflags;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Onglet3 extends Fragment {
    /*@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view= inflater.inflate(R.layout.fragment_trois,container,false);*/
    PDFView pdfView;
    //final List<String> pf=new ArrayList<>();
    final List<String> pdfList=new ArrayList<>();
    final List<String> pdfList2=new ArrayList<>();
    final List<String> pdfList3=new ArrayList<>();
    final List<String> pdfList4=new ArrayList<>();
    final List<String> pdfList5=new ArrayList<>();
    final List<String> pdfList6=new ArrayList<>();
    final List<String> pdfList7=new ArrayList<>();
    final List<String> pdfList8=new ArrayList<>();
    final List<String> pdfList9=new ArrayList<>();
    final List<String> pdfList10=new ArrayList<>();
    final List<String> pdfList11=new ArrayList<>();
    final List<String> pdfList12=new ArrayList<>();
    final List<String> pdfList11a=new ArrayList<>();
    final List<String> pdfList12a=new ArrayList<>();
    final List<String> pdfList11b=new ArrayList<>();
    final List<String> pdfList12b=new ArrayList<>();
    final List<String> pdfList13=new ArrayList<>();
    final List<String> pdfList14=new ArrayList<>();
    final List<String> pdfList15=new ArrayList<>();
    final List<String> pdfList16=new ArrayList<>();
    final List<String> pdfList17=new ArrayList<>();
    final List<String> pdfList18=new ArrayList<>();
    final List<String> pdfList19=new ArrayList<>();
    final List<String> pdfList20=new ArrayList<>();
    final List<String> pdfList21=new ArrayList<>();
    final List<String> pdfList22=new ArrayList<>();
    final List<String> pdfList23=new ArrayList<>();
    final List<String> pdfList24=new ArrayList<>();
    final List<String> pdfList23a=new ArrayList<>();
    final List<String> pdfList24a=new ArrayList<>();
    final List<String> pdfList23b=new ArrayList<>();
    final List<String> pdfList24b=new ArrayList<>();



    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://my-flags.appspot.com");
    String [] dossier={"111","111/Anglais","121","121/Anglais","131","131/Anglais","141","141/Anglais","151","151/Anglais","161","161/Anglais","171","171/Anglais","181","181/Anglais","Semestre2/112","Semestre2/112/Anglais","Semestre2/122","Semestre2/122/Anglais","Semestre2/132","Semestre2/132/Anglais","Semestre2/142","Semestre2/142/Anglais","Semestre2/152","Semestre2/152/Anglais","Semestre2/162","Semestre2/162/Anglais","Semestre2/172","Semestre2/172/Anglais","Semestre2/182","Semestre/182/Anglais"};
    StorageReference fileRef;
    StorageReference fileRef2;
    StorageReference fileRef3;
    StorageReference fileRef4;
    StorageReference fileRef5;
    StorageReference fileRef6;
    StorageReference fileRef7;
    StorageReference fileRef8;
    StorageReference fileRef9;
    StorageReference fileRef10;
    StorageReference fileRef11;
    StorageReference fileRef12;
    StorageReference fileRef11a;
    StorageReference fileRef12a;
    StorageReference fileRef11b;
    StorageReference fileRef12b;
    StorageReference fileRef13;
    StorageReference fileRef14;
    StorageReference fileRef15;
    StorageReference fileRef16;
    StorageReference fileRef17;
    StorageReference fileRef18;
    StorageReference fileRef19;
    StorageReference fileRef20;
    StorageReference fileRef21;
    StorageReference fileRef22;
    StorageReference fileRef23;
    StorageReference fileRef24;
    StorageReference fileRef23a;
    StorageReference fileRef24a;
    StorageReference fileRef23b;
    StorageReference fileRef24b;
    int k;
    StorageReference [] fil={fileRef,fileRef2,fileRef3,fileRef4,fileRef5,fileRef6,fileRef7,fileRef8,fileRef9,fileRef10,fileRef11,fileRef12,fileRef11a,fileRef12a,fileRef11b,fileRef12b,fileRef13,fileRef14,fileRef15,fileRef16,fileRef17,fileRef18,fileRef19,fileRef20,fileRef21,fileRef22,fileRef23,fileRef24,fileRef23a,fileRef24a,fileRef23b,fileRef24b};

    //FirebaseFirestore db=FirebaseFirestore.getInstance();
    //DocumentReference reference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view= inflater.inflate(R.layout.fragment_trois,container,false);
        RecyclerView RecyclerView=view.findViewById(R.id.liste1);
        pdfView=view.findViewById(R.id.pdfview);
       AdaptCours adapter=new AdaptCours(pdfList);
       AdaptCours adapter2=new AdaptCours(pdfList2);
       AdaptCours adapter3=new AdaptCours(pdfList3);
       AdaptCours adapter4=new AdaptCours(pdfList4);
       AdaptCours adapter5=new AdaptCours(pdfList5);
       AdaptCours adapter6=new AdaptCours(pdfList6);
       AdaptCours adapter7=new AdaptCours(pdfList7);
       AdaptCours adapter8=new AdaptCours(pdfList8);
       AdaptCours adapter9=new AdaptCours(pdfList9);
       AdaptCours adapter10=new AdaptCours(pdfList10);
       AdaptCours adapter11=new AdaptCours(pdfList11);
       AdaptCours adapter12=new AdaptCours(pdfList12);
        AdaptCours adapter11a=new AdaptCours(pdfList11a);
        AdaptCours adapter12a=new AdaptCours(pdfList12a);
        AdaptCours adapter11b=new AdaptCours(pdfList11b);
        AdaptCours adapter12b=new AdaptCours(pdfList12b);
       AdaptCours adapter13=new AdaptCours(pdfList13);
       AdaptCours adapter14=new AdaptCours(pdfList14);
       AdaptCours adapter15=new AdaptCours(pdfList15);
       AdaptCours adapter16=new AdaptCours(pdfList16);
       AdaptCours adapter17=new AdaptCours(pdfList17);
       AdaptCours adapter18=new AdaptCours(pdfList18);
       AdaptCours adapter19=new AdaptCours(pdfList19);
       AdaptCours adapter20=new AdaptCours(pdfList20);
       AdaptCours adapter21=new AdaptCours(pdfList21);
       AdaptCours adapter22=new AdaptCours(pdfList22);
       AdaptCours adapter23=new AdaptCours(pdfList23);
       AdaptCours adapter24=new AdaptCours(pdfList24);
        AdaptCours adapter23a=new AdaptCours(pdfList23a);
        AdaptCours adapter24a=new AdaptCours(pdfList24a);
        AdaptCours adapter23b=new AdaptCours(pdfList23b);
        AdaptCours adapter24b=new AdaptCours(pdfList24b);
        /*adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        adapter3.notifyDataSetChanged();
        adapter4.notifyDataSetChanged();
        adapter5.notifyDataSetChanged();
        adapter6.notifyDataSetChanged();
        adapter7.notifyDataSetChanged();
        adapter8.notifyDataSetChanged();
        adapter9.notifyDataSetChanged();
        adapter10.notifyDataSetChanged();
        adapter11.notifyDataSetChanged();
        adapter12.notifyDataSetChanged();
        adapter13.notifyDataSetChanged();
        adapter14.notifyDataSetChanged();
        adapter15.notifyDataSetChanged();
        adapter16.notifyDataSetChanged();
        adapter17.notifyDataSetChanged();
        adapter18.notifyDataSetChanged();
        adapter19.notifyDataSetChanged();
        adapter20.notifyDataSetChanged();
        adapter21.notifyDataSetChanged();
        adapter22.notifyDataSetChanged();
        adapter23.notifyDataSetChanged();
        adapter24.notifyDataSetChanged();*/
        /*List<List<String>> pf=new ArrayList<List<String>>();
        pf.add(pdfList);
        pf.add(pdfList2);
        pf.add(pdfList3);
        pf.add(pdfList4);
        pf.add(pdfList5);
        pf.add(pdfList6);
        pf.add(pdfList7);
        pf.add(pdfList8);
        pf.add(pdfList9);
        pf.add(pdfList10);
        pf.add(pdfList11);
        pf.add(pdfList12);
        pf.add(pdfList13);
        pf.add(pdfList14);
        pf.add(pdfList15);
        pf.add(pdfList16);
        pf.add(pdfList17);
        pf.add(pdfList18);
        pf.add(pdfList19);
        pf.add(pdfList20);
        pf.add(pdfList21);
        pf.add(pdfList22);
        pf.add(pdfList23);
        pf.add(pdfList24);*/
        for(k=0;k<32;k++){
            fil[k]=storageRef.child(dossier[k]);
        }
        //fil[2]=storageRef.child("121");
        //Toast.makeText(getContext(), storageRef.child("121").toString(), Toast.LENGTH_LONG).show();
        RecyclerView RecyclerView2=view.findViewById(R.id.liste2);
        RecyclerView RecyclerView3=view.findViewById(R.id.liste3);
        RecyclerView RecyclerView4=view.findViewById(R.id.liste4);
        RecyclerView RecyclerView5=view.findViewById(R.id.liste5);
        RecyclerView RecyclerView6=view.findViewById(R.id.liste6);
        RecyclerView RecyclerView7=view.findViewById(R.id.liste7);
        RecyclerView RecyclerView8=view.findViewById(R.id.liste8);
        RecyclerView RecyclerView9=view.findViewById(R.id.liste9);
        RecyclerView RecyclerView10=view.findViewById(R.id.liste10);
        RecyclerView RecyclerView11=view.findViewById(R.id.liste11);
        RecyclerView RecyclerView12=view.findViewById(R.id.liste12);
        RecyclerView RecyclerView11a=view.findViewById(R.id.liste11a);
        RecyclerView RecyclerView12a=view.findViewById(R.id.liste12a);
        RecyclerView RecyclerView11b=view.findViewById(R.id.liste11b);
        RecyclerView RecyclerView12b=view.findViewById(R.id.liste12b);
        RecyclerView RecyclerView13=view.findViewById(R.id.liste13);
        RecyclerView RecyclerView14=view.findViewById(R.id.liste14);
        RecyclerView RecyclerView15=view.findViewById(R.id.liste15);
        RecyclerView RecyclerView16=view.findViewById(R.id.liste16);
        RecyclerView RecyclerView17=view.findViewById(R.id.liste17);
        RecyclerView RecyclerView18=view.findViewById(R.id.liste18);
        RecyclerView RecyclerView19=view.findViewById(R.id.liste19);
        RecyclerView RecyclerView20=view.findViewById(R.id.liste20);
        RecyclerView RecyclerView21=view.findViewById(R.id.liste21);
        RecyclerView RecyclerView22=view.findViewById(R.id.liste22);
        RecyclerView RecyclerView23=view.findViewById(R.id.liste23);
        RecyclerView RecyclerView24=view.findViewById(R.id.liste24);
        RecyclerView RecyclerView23a=view.findViewById(R.id.liste23a);
        RecyclerView RecyclerView24a=view.findViewById(R.id.liste24a);
        RecyclerView RecyclerView23b=view.findViewById(R.id.liste23b);
        RecyclerView RecyclerView24b=view.findViewById(R.id.liste24b);
        RecyclerView [] affich ={RecyclerView,RecyclerView2,RecyclerView3,RecyclerView4,RecyclerView5,RecyclerView6,RecyclerView7,RecyclerView8,RecyclerView9,RecyclerView10,RecyclerView11,RecyclerView12,RecyclerView13,RecyclerView14,RecyclerView15,RecyclerView16,RecyclerView17,RecyclerView18,RecyclerView19,RecyclerView20,RecyclerView21,RecyclerView22,RecyclerView23,RecyclerView24};
        afficher(pdfList,fil[0],RecyclerView,adapter);
        afficher(pdfList2,fil[1],RecyclerView2,adapter2);
        afficher(pdfList3,fil[2],RecyclerView3,adapter3);
        afficher(pdfList4,fil[3],RecyclerView4,adapter4);
        afficher(pdfList5,fil[4],RecyclerView5,adapter5);
        afficher(pdfList6,fil[5],RecyclerView6,adapter6);
        afficher(pdfList7,fil[6],RecyclerView7,adapter7);
        afficher(pdfList8,fil[7],RecyclerView8,adapter8);
        afficher(pdfList9,fil[8],RecyclerView9,adapter9);
        afficher(pdfList10,fil[9],RecyclerView10,adapter10);
        afficher(pdfList11,fil[10],RecyclerView11,adapter11);
        afficher(pdfList12,fil[11],RecyclerView12,adapter12);
        afficher(pdfList11a,fil[12],RecyclerView11a,adapter11a);
        afficher(pdfList12a,fil[13],RecyclerView12a,adapter12a);
        afficher(pdfList11b,fil[14],RecyclerView11b,adapter11b);
        afficher(pdfList12b,fil[15],RecyclerView12b,adapter12b);
        afficher(pdfList13,fil[16],RecyclerView13,adapter13);
        afficher(pdfList14,fil[17],RecyclerView14,adapter14);
        afficher(pdfList15,fil[18],RecyclerView15,adapter15);
        afficher(pdfList16,fil[19],RecyclerView16,adapter16);
        afficher(pdfList17,fil[20],RecyclerView17,adapter17);
        afficher(pdfList18,fil[21],RecyclerView18,adapter18);
        afficher(pdfList19,fil[22],RecyclerView19,adapter19);
        afficher(pdfList20,fil[23],RecyclerView20,adapter20);
        afficher(pdfList21,fil[24],RecyclerView21,adapter21);
        afficher(pdfList22,fil[25],RecyclerView22,adapter22);
        afficher(pdfList23,fil[26],RecyclerView23,adapter23);
        afficher(pdfList24,fil[27],RecyclerView24,adapter24);
        afficher(pdfList23a,fil[28],RecyclerView23a,adapter23a);
        afficher(pdfList24a,fil[29],RecyclerView24a,adapter24a);
        afficher(pdfList23b,fil[30],RecyclerView23b,adapter23b);
        afficher(pdfList24b,fil[31],RecyclerView24b,adapter24b);
        adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        adapter3.notifyDataSetChanged();
        adapter4.notifyDataSetChanged();
        adapter5.notifyDataSetChanged();
        adapter6.notifyDataSetChanged();
        adapter7.notifyDataSetChanged();
        adapter8.notifyDataSetChanged();
        adapter9.notifyDataSetChanged();
        adapter10.notifyDataSetChanged();
        adapter11.notifyDataSetChanged();
        adapter12.notifyDataSetChanged();
        adapter11a.notifyDataSetChanged();
        adapter12a.notifyDataSetChanged();
        adapter11b.notifyDataSetChanged();
        adapter12b.notifyDataSetChanged();
        adapter13.notifyDataSetChanged();
        adapter14.notifyDataSetChanged();
        adapter15.notifyDataSetChanged();
        adapter16.notifyDataSetChanged();
        adapter17.notifyDataSetChanged();
        adapter18.notifyDataSetChanged();
        adapter19.notifyDataSetChanged();
        adapter20.notifyDataSetChanged();
        adapter21.notifyDataSetChanged();
        adapter22.notifyDataSetChanged();
        adapter23.notifyDataSetChanged();
        adapter24.notifyDataSetChanged();
        adapter23a.notifyDataSetChanged();
        adapter24a.notifyDataSetChanged();
        adapter23b.notifyDataSetChanged();
        adapter24b.notifyDataSetChanged();
        return view;
    }
    void afficher(List<String> pf,StorageReference fil,RecyclerView RecyclerView,AdaptCours adapter){
        if(fil!=null) {
            fil.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
                @Override
                public void onSuccess(ListResult listResult) {
                    List<StorageReference> pdfFiles = new ArrayList<>();
                    for (StorageReference item : listResult.getItems()) {
                        if (item.getName().endsWith(".pdf")) {
                            pdfFiles.add(item);
                        }
                    }
                    //System.out.println(pdfFiles.get(1).getName().toString());
                    for (StorageReference file : pdfFiles) {
                        if (!pf.contains(file.getName())) {
                            pf.add(file.getName());
                        }
                    }

                    //Toast.makeText(getContext(), pf.get(1)+"bonjour", Toast.LENGTH_SHORT).show();
                    //adapter.clear();
                    //adapter.addAll(pf);
                    //adapter.notifyDataSetChanged();
                    RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    RecyclerView.setAdapter(adapter);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                }
            });
            adapter.setOnItemClickListener(new AdaptCours.OnItemClickListener() {
                @Override
                public void onItemClick(int i) {
                    StorageReference fis = fil.child(pf.get(i));

                    Map<String, Object> document = new HashMap<>();
                    //new RetrivePDFfromUrl().execute(fis.getDownloadUrl().toString());
                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    DocumentReference reference = db.collection("documents").document(pf.get(i));
                    fis.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            document.put("url",uri.toString());
                            reference.set(document);
                        }
                    });
                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String pdfUrl = documentSnapshot.getString("url");
                                Intent intent = new Intent(getActivity(), PDFActivity.class);
                                intent.putExtra("pdfUrl", pdfUrl);
                                System.out.println("ouverture");
                                startActivity(intent);
                                //new RetrivePDFfromUrl().execute(pdfUrl);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println("non ouvert");
                        }
                    });
                }
            });
        }
        else{
            return;
        }
    }
}
