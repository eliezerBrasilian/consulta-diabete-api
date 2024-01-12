import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { Home } from '../pages/Home/Home';
import { Result } from '../pages/Result/Result';

function RoutesApp() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Home />} path='/' />
        <Route element={<Result />} path='/result/:id/:type' />
      </Routes>
    </BrowserRouter>
  );
}

export { RoutesApp };
