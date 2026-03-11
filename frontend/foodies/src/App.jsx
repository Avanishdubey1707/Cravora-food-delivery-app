import React from 'react';
import Menubar from './components/Menubar/Menubar';
import Contact from './pages/Contact/Contact';
import ExploreFood from './pages/ExploreFood/ExploreFood';
import Home from './pages/Home/Home';
import { Routes, Route } from 'react-router-dom';

const App = () => {
  return (
    <div>
      <Menubar />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/contact' element={<Contact />} />
        <Route path='/explore' element={<ExploreFood/>} />
      </Routes>
    </div>
  )
}

export default App;