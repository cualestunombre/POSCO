import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom';
import {Routes, Route} from 'react-router';

import {Main} from "./component/main";
import {About} from "./component/about";
import {Guestbook} from "./component/guestbook";
import {Gallery} from "./component/gallery";
import {Login, Join} from "./component/user";
import {Error404} from "./component/error";
import {SiteLayout} from "./layout"
import './assets/scss/App.scss'

const AppRoutes = () => {
    return useRoutes([
        { path: '/', element: <Main /> },
        { path: '/gallery', element: <Gallery /> },
        { path: '/guestbook', element: <Guestbook /> },
        { path: '/about', element: <About /> },
        { path: '/user/join', element: <Join /> },
        { path: '/user/login', element: <Login /> },
        { path: '*', element: <Error404 /> }
    ]);
}

export default function App() {
    return (
        <Router>
            <SiteLayout>
                <AppRoutes />
            </SiteLayout>
        </Router>
    );
}