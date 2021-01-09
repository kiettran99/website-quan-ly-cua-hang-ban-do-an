import React, { useState, useEffect } from 'react'
import PropTypes from 'prop-types'
import { getColor } from '@coreui/utils'
import { CChart } from '@coreui/react-chartjs'
import useGetOrders from './hooks/useGetOrders';
import { getLabelByTypeDate, exportTotalOrdersByTypeDate } from '../../utils/charBarUtils';

const ChartLineTotal = (props) => {
    const { typeDate, ...attributes } = props;

    const orders = useGetOrders();

    useEffect(() => {
        setData(exportTotalOrdersByTypeDate(orders, typeDate));
    }, [typeDate, orders]);


    const [data, setData] = useState([]);

    const bar = {
        labels: getLabelByTypeDate(typeDate),
        datasets: [
            {
                label: 'Tổng tiền hóa đơn',
                fill: false,
                lineTension: 0.1,
                backgroundColor: 'rgba(75,192,192,0.4)',
                borderColor: 'rgba(75,192,192,1)',
                borderCapStyle: 'butt',
                borderDash: [],
                borderDashOffset: 0.0,
                borderJoinStyle: 'miter',
                pointBorderColor: 'rgba(75,192,192,1)',
                pointBackgroundColor: '#fff',
                pointBorderWidth: 1,
                pointHoverRadius: 5,
                pointHoverBackgroundColor: 'rgba(75,192,192,1)',
                pointHoverBorderColor: 'rgba(220,220,220,1)',
                pointHoverBorderWidth: 2,
                pointRadius: 1,
                pointHitRadius: 10,
                data,
            },
        ],
    };

    const options = {
        // tooltips: {
        //   enabled: false,
        //   custom: customTooltips
        // },
        maintainAspectRatio: false
    }

    return (
        <div className="chart-wrapper">
            <CChart type="line"
                {...attributes}
                labels={bar.labels}
                datasets={bar.datasets} options={options} />
        </div>
    );
};

export default ChartLineTotal;