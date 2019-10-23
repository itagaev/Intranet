#include<bits/stdc++.h>

#define int long long
#define all(x) (x).begin(), (x).end()
#define pb push_back
#define mp make_pair
#define F first
#define S second 
#define _ <<" "
#define __ <<endl
#define speedup ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0)

using namespace std;
bool ok=true;
stringstream ss;
const int N = (int)1e9+7;


signed main(){
    speedup;
    string a,b;
    cin>>a>>b;
    string ans = "" ;
    if( a.size() < b.size() ) swap(a,b);
    if(a.find(b)!=string::npos){
    	cout<< a;
    }else{
    	string check = "";
    	string part = "";
    	for(int i=b.size() - 1 ; i>= 0 ; i--){
    		part = b[i] + part;
    		check = a + part;
    		// cout<<part<<" "<< check<< endl;
    		if(check.find(b, check.size() - b.size() - 1 ) != string::npos ){
				ans = check;
				break;    			
    		} 
    	}
    	// cout<<endl;
    	part = "";
    	for(int i=0 ; i < b.size() ; i++){
    		part = part + b[i];
    		check = part + a;
    		// cout<<part<<" "<< check<< endl;
    		if(check.find(b,0)!=string::npos and i < b.size()+2 ){
    			if(check.size()  > ans.size() ){
    				cout<<ans;
    				return 0;
    			}else{
    				cout<<check;
    				return 0;
    			}
    		}
    	}
    	cout<<a<<b<<endl;
    }

    return 0;
}       
