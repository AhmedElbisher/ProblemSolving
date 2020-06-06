/*
A hotel manager has to process N advance bookings of rooms for the next season.
His hotel has K rooms.Bookings contain an arrival date and a departure date.
He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
Write a program that solves this problem in time O(N log N) .
 */

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {
    public class Node implements Comparable<Node>{
        public int time;
        public int state;
        public Node(int t , int s){
            this.time = t;
            this.state = s;

        }
        @Override
        public int compareTo(Node arg0) {
            if(this.time < arg0.time) {
                return 1;
            }else if (this.time == arg0.time ){
                if( this.state == arg0.state) return 0;
                else if(this.state==1)return -1;
                else return 1;
            }else {
                return -1;
            }
        }

    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        for(int i : depart ) {
            nodes.add(new Node(i,0));

        }

        for(int i : arrive ) {
            nodes.add(new Node(i,1));
        }
        Collections.sort(nodes, Collections.reverseOrder());

        for(Node n : nodes) {
            if(n.state == 1) {
                if(--k <0) return false;
            }else {
                k++;
            }
        }
        return true;

    }
}
