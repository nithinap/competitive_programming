#include<iostream>

using namespace std;
// a Point is defined by its coordinates {int x, y;}
struct Point
{
    int x;
    int y;
};
 
// isLeft(): tests if a point is Left|On|Right of an infinite line.
//    Input:  three points P0, P1, and P2
//    Return: >0 for P2 left of the line through P0 and P1
//            =0 for P2  on the line
//            <0 for P2  right of the line

inline int isLeft( Point P0, Point P1, Point P2 )
{
    return ( (P1.x - P0.x) * (P2.y - P0.y)
            - (P2.x -  P0.x) * (P1.y - P0.y) );
}

// cn_PnPoly(): crossing number test for a point in a polygon
//      Input:   P = a point,
//               V[] = vertex points of a polygon V[n+1] with V[n]=V[0]
//      Return:  0 = outside, 1 = inside

int cn_PnPoly( Point P, Point* V, int n )
{
    int    cn = 0;    // the  crossing number counter

    // loop through all edges of the polygon
    for (int i=0; i<n; i++) {    // edge from V[i]  to V[i+1]
       if (((V[i].y <= P.y) && (V[i+1].y > P.y))     // an upward crossing
        || ((V[i].y > P.y) && (V[i+1].y <=  P.y))) { // a downward crossing
            // compute  the actual edge-ray intersect x-coordinate
            float vt = (float)(P.y  - V[i].y) / (V[i+1].y - V[i].y);
            if (P.x <  V[i].x + vt * (V[i+1].x - V[i].x)) // P.x < intersect
                 ++cn;   // a valid crossing of y=P.y right of P.x
        }
    }
    return (cn&1);    // 0 if even (out), and 1 if  odd (in)

}

// wn_PnPoly(): winding number test for a point in a polygon
//      Input:   P = a point,
//               V[] = vertex points of a polygon V[n+1] with V[n]=V[0]
//      Return:  wn = the winding number (=0 only when P is outside)

int wn_PnPoly( Point P, Point* V, int n )
{
    int    wn = 0;    // the  winding number counter

    // loop through all edges of the polygon
    for (int i=0; i<n; i++) {   // edge from V[i] to  V[i+1]
        if (V[i].y <= P.y) {          // start y <= P.y
            if (V[i+1].y  > P.y)      // an upward crossing
                 if (isLeft( V[i], V[i+1], P) > 0)  // P left of  edge
                     ++wn;            // have  a valid up intersect
        }
        else {                        // start y > P.y (no test needed)
            if (V[i+1].y  <= P.y)     // a downward crossing
                 if (isLeft( V[i], V[i+1], P) < 0)  // P right of  edge
                     --wn;            // have  a valid down intersect
        }
    }
    return wn;
}

int main()
{
    int t, n;
    cin>>t;
    while (t--) {
        cin>>n;
        Point PolygonVertex[n][100000];
        int m[n];
        for(int i=0; i<n; i++) {
            cin>>m[i];
            for(int j=0; j<m[i]; j++) {
                cin>>PolygonVertex[i][j].x;
                cin>>PolygonVertex[i][j].y;
            }
        }

        for(int i=0; i<n-1; i++) {
            //cout<<"Polygon vertices: "<<endl;
            for(int j=i+1; j<n; j++) {
                cout<<"Polygon "<<j<<endl;
                for(int k=0; k<m[j]; k++) {
                        cout<<"X["<<k<<"] : "<<PolygonVertex[j][k].x<<"  ;  ";
                        cout<<"Y{"<<k<<"] : "<<PolygonVertex[j][k].y<<endl;

                        if(wn_Poly(PolygonVertex[j][k], PolygonVertex[i], m[i]) == 0) {
                                cout<<"Polygon "<<j<<" outside "<<i;
                                break;
                        }

                }
            }
        }

    }
    return 0;
}

