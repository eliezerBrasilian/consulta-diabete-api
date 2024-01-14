import 'react-toastify/dist/ReactToastify.css';

import { ToastContainer, toast } from 'react-toastify';

import axios from 'axios';
import React from 'react';
import { Link } from 'react-router-dom';
import styles from './Home.module.css';

function Home() {
  const [sintomasChecked, setSintomasChecked] = React.useState(new Array());
  const [result, setResult] = React.useState(null);
  async function sendSyntoms() {
    try {
      var response = await axios.post(
        'http://localhost:8080/symptoms',
        JSON.stringify(sintomasChecked),
        { headers: { 'Content-Type': 'application/json' } }
      );
      toast('Seu resultado está pronto', {
        type: 'success',
      });
      setResult(response.data);
    } catch (error) {
      var message = String(error.response.data);
      if (message.includes('do que o minimo esperado')) {
        toast('Você deve adicionar no mínimo 5 sntomas', {
          type: 'error',
        });
      }
    }
  }

  function handleChange(event) {
    var currentValue = event.target.value;
    var currentElementIsChecked = event.target.checked;

    if (currentElementIsChecked) {
      setSintomasChecked((data) => [...data, currentValue]);
    } else {
      setSintomasChecked((data) => {
        var newArray = new Array();

        for (let i = 0; i < data.length; i++) {
          if (data[i] != currentValue) {
            newArray.push(data[i]);
          }
        }
        return newArray;
      });
    }
  }
  // console.log(sintomasChecked);

  return (
    <div className={styles.container}>
      <h1>Descubra se você tem chance de possuir diabetes</h1>
      <p>Escolha os sintomas</p>
      <div className={styles.checkboxesContainer}>
        <div className={styles.left}>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Perda de peso não intencional'
              id='1'
              onChange={handleChange}
            />
            <label htmlFor='1'>Perda de peso não intencional</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Dor de estômago e vômitos'
              id='2'
              onChange={handleChange}
            />
            <label htmlFor='2'>Dor de estômago e vômitos</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Respiração pesada'
              id='3'
              onChange={handleChange}
            />
            <label htmlFor='3'>Respiração pesada</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Excesso de apetite'
              id='4'
              onChange={handleChange}
            />
            <label htmlFor='4'>Excesso de apetite</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Formigamento/dormência'
              id='5'
              onChange={handleChange}
            />
            <label htmlFor='5'>Formigamento/dormência</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Dor de estômago e vômitos'
              id='6'
              onChange={handleChange}
            />
            <label htmlFor='6'>Dor de estômago e vômitos</label>
          </div>
        </div>

        <div className={styles.right}>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Dor de estômago e vômitos'
              id='6'
              onChange={handleChange}
            />
            <label htmlFor='6'>Dor de estômago e vômitos</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Formação de manchas escuras na pele'
              id='7'
              onChange={handleChange}
            />
            <label htmlFor='7'>Formação de manchas escuras na pele</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Infecções frequentes (epiteliais e vaginais)'
              id='8'
              onChange={handleChange}
            />
            <label htmlFor='8'>
              Infecções frequentes (epiteliais e vaginais)
            </label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Sede excessiva'
              id='9'
              onChange={handleChange}
            />
            <label htmlFor='9'>Sede excessiva</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Micção frequente'
              id='10'
              onChange={handleChange}
            />
            <label htmlFor='10'>Micção frequente</label>
          </div>

          <div className={styles.item}>
            <input
              type='checkbox'
              value='Alteração frequente de humor'
              id='11'
              onChange={handleChange}
            />
            <label htmlFor='11'>Alteração frequente de humor</label>
          </div>
          <div className={styles.item}>
            <input
              type='checkbox'
              value='Excesso de apetite'
              id='12'
              onChange={handleChange}
            />
            <label htmlFor='12'>Excesso de apetite</label>
          </div>
        </div>
      </div>
      <div className={styles.buttonsContainer}>
        <button onClick={sendSyntoms}>Consultar</button>
        {result != null && (
          <Link to={`/result/${result.id}/${result.result}`}>
            Exibir resultado
          </Link>
        )}
      </div>
      <ToastContainer />
    </div>
  );
}

export { Home };
