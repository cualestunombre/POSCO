import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom';
import {Routes, Route} from 'react-router';
import Main from "./component/Main";
import Gallery from "./component/Gallery";
import Guestbook from "./component/Guestbook";
import About from "./component/About";
import Error404 from "./component/Error404";
import Header from './layout/Header';
import Navigation from "./layout/Navigation";
import Footer from "./layout/Footer";

import './assets/scss/App.scss'

export default function App() {
    return (
        <>
            

            <Router>
                <Header/>
                <Navigation/>
                <Routes>
                    <Route path='/' element={<Main />}/>
                    <Route path='/gallery' element={<Gallery />}/>
                    <Route path='/guestbook' element={<Guestbook />}/>
                    <Route path='/about' element={<About />}/>
                    <Route path='*' element={<Error404 />}/>
                </Routes>
                <Footer/>
            </Router>
           
        </>
    );
}