import firebase from 'firebase/app';
import 'firebase/firestore';
import 'firebase/database';
import 'firebase/auth';
import 'firebase/storage';

require('dotenv').config()

const firebaseConfig = {
    apiKey: process.env.REACT_APP_API_KEY,
    authDomain: "bayareaevents-eecee.firebaseapp.com",
    databaseURL: "https://bayareaevents-eecee-default-rtdb.firebaseio.com/",
    projectId: "bayareaevents-eecee",
    storageBucket: "bayareaevents-eecee.appspot.com",
    messagingSenderId: "211100466533",
    appId: "1:211100466533:web:1324baa03c220bdc94758c"
}

firebase.initializeApp(firebaseConfig);
firebase.firestore();

export default firebase;