package com.alex.vkdemo;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alex.vkdemo.dummy.VkNewsItem;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VkNewsItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VkNewsItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VkNewsItemFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private VkNewsItem vkNewsItem;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static VkNewsItemFragment newInstance(VkNewsItem item) {
        VkNewsItemFragment fragment = new VkNewsItemFragment();
        fragment.setVkNewsItem(item);
        return fragment;
    }

    public VkNewsItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_news_item, container, false);
        return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setVkNewsItem(VkNewsItem vkNewsItem) {
        this.vkNewsItem = vkNewsItem;
    }

    public VkNewsItem getVkNewsItem() {
        return vkNewsItem;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

    }

}
